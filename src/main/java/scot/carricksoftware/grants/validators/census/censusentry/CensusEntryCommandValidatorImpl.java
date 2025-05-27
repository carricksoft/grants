/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.censusentry;

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
        validateCoExistences(censusEntryCommand, bindingResult);
        validateIntegers(censusEntryCommand, bindingResult);
        if (censusEntryCommand.getBirthDay() != null && !censusEntryCommand.getBirthDay().isEmpty()) {
            validateBirthDay(censusEntryCommand, bindingResult);
        }
    }

    private void validateCoExistences(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        validateNameAndPerson(censusEntryCommand, bindingResult);
        validateAgeAndBirthYear(censusEntryCommand, bindingResult);
        validateAgeAndBirthDay(censusEntryCommand, bindingResult);
    }

    private void validateIntegers(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getChildrenBornAlive() != null && !censusEntryCommand.getChildrenBornAlive().isEmpty()) {
            validateIntegerNoLimits(censusEntryCommand.getChildrenBornAlive(), "childrenBornAlive", bindingResult);
        }
        if (censusEntryCommand.getChildrenStillAlive() != null && !censusEntryCommand.getChildrenStillAlive().isEmpty()) {
            validateIntegerNoLimits(censusEntryCommand.getChildrenStillAlive(), "childrenStillAlive", bindingResult);
        }
        if (censusEntryCommand.getChildrenWhoHaveDied() != null && !censusEntryCommand.getChildrenWhoHaveDied().isEmpty()) {
            validateIntegerNoLimits(censusEntryCommand.getChildrenWhoHaveDied(), "childrenWhoHaveDied", bindingResult);
        }
        if (censusEntryCommand.getYearsCompletedMarriage() != null && !censusEntryCommand.getYearsCompletedMarriage().isEmpty()) {
            validateIntegerNoLimits(censusEntryCommand.getYearsCompletedMarriage(), "yearsCompletedMarriage", bindingResult);
        }
        if (censusEntryCommand.getBirthYear() != null && !censusEntryCommand.getBirthYear().isEmpty()) {
            validateInteger(censusEntryCommand.getBirthYear(), 1800, 2050, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER, "birthYear", bindingResult);
        }
    }


    private void validateAgeAndBirthYear(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getBirthYear() != null && !censusEntryCommand.getBirthYear().isEmpty()) {
            if (censusEntryCommand.getAge() != null && !censusEntryCommand.getAge().isEmpty()) {
                bindingResult.rejectValue("birthYear", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);

                bindingResult.rejectValue("age", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);
            }
        }
    }


    private void validateAgeAndBirthDay(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getBirthDay() != null && !censusEntryCommand.getBirthDay().isEmpty()) {
            if (censusEntryCommand.getAge() != null && !censusEntryCommand.getAge().isEmpty()) {
                bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);

                bindingResult.rejectValue("age", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);
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

    private void validateIntegerNoLimits(String part, String field, BindingResult bindingResult) {
        boolean invalid = false;
        try {
            int value = Integer.parseInt(part);
            if (value < 0) {
                invalid = true;
            }
        } catch (RuntimeException e) {
            invalid = true;
        }
        if (invalid) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
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

