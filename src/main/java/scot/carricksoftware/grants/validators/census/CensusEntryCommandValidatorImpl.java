/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class CensusEntryCommandValidatorImpl implements CensusEntryCommandValidator {

    private static final Logger logger = LogManager.getLogger(CensusEntryCommandValidatorImpl.class);

    @Override
    public void validate(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        logger.debug("censusEntryCommandValidator::validate");
        validateCensus(censusEntryCommand, bindingResult);
        validateNameAndPerson(censusEntryCommand, bindingResult);
        if (censusEntryCommand.getBirthDay() != null) {
            validateBirthDay(censusEntryCommand, bindingResult);
        }
        if (censusEntryCommand.getBirthYear() != null) {
            validateBirthYear(censusEntryCommand, bindingResult);
        }
        validateAgeAndBirthYear(censusEntryCommand, bindingResult);
        validateAgeAndBirthDay(censusEntryCommand, bindingResult);
    }

    private void validateAgeAndBirthDay(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getBirthDay() != null) {
            if (censusEntryCommand.getAge() != null) {
                bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);

                bindingResult.rejectValue("age", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);
            }
        }
    }

    private void validateAgeAndBirthYear(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getBirthYear() != null) {
            if (censusEntryCommand.getAge() != null) {
                bindingResult.rejectValue("birthYear", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);

                bindingResult.rejectValue("age", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);
            }
        }
    }

    private void validateBirthDay(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        String[] parts = censusEntryCommand.getBirthDay().split("/");
        if (parts.length != 2) {
            bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
        } else {
            validateInteger(parts[0], 1, 31, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT, "birthDay", bindingResult);
            validateInteger(parts[1], 1, 12, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT, "birthDay", bindingResult);

        }
    }

    private void validateInteger(String part, int low, int high, String validationConstant, String field, BindingResult bindingResult) {
        boolean invalid = false;
        try {
            int value = Integer.parseInt(part);
            if (value < low || value > high) {
                invalid = true;
            }
        } catch (RuntimeException e) {
            invalid = true;
        }
        if (invalid) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING,
                    null,
                    validationConstant);
        }
    }

    private void validateBirthYear(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        validateInteger(censusEntryCommand.getBirthYear(), 1800, 2050, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER, "birthYear", bindingResult);
    }


    private void validateNameAndPerson(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getPerson() == null) {
            if (censusEntryCommand.getName() == null || censusEntryCommand.getName().isEmpty()) {
                bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.CENSUS_NAME_IS_NULL);
                bindingResult.rejectValue("person", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.CENSUS_NAME_IS_NULL);
            } else {
                validateUntrackedPerson(censusEntryCommand, bindingResult);
            }
        } else {
            if (censusEntryCommand.getName() != null && !censusEntryCommand.getName().isEmpty()) {
                bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.CENSUS_NAME_IS_NOT_NULL);
                bindingResult.rejectValue("person", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.CENSUS_NAME_IS_NOT_NULL);
            }
        }
    }

    private void validateCensus(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getCensus() == null) {
            bindingResult.rejectValue("census", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.CENSUS_IS_NULL);
        }
    }

    private void validateUntrackedPerson(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getName().length() < ApplicationConstants.MINIMUM_NAME_LENGTH) {
            bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.NAME_IS_TOO_SHORT);
        } else {
            if (censusEntryCommand.getName().length() > ApplicationConstants.MAXIMUM_NAME_LENGTH) {
                bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.NAME_IS_TOO_LONG);
            }
        }
    }



}

