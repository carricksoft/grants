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
        validateBirthYear(censusEntryCommand, bindingResult);
        validateBirthDay(censusEntryCommand, bindingResult);
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
        if (censusEntryCommand.getBirthDay() != null) {
            if (!censusEntryCommand.getBirthDay().contains("/")) {
                bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
            } else {
                String[] parts = censusEntryCommand.getBirthDay().split("/");
                if (parts.length == 2) {
                    validateDays(parts[0], bindingResult);
                    validateYears(parts[1], bindingResult);
                } else {
                    bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                            null,
                            ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
                }
            }
        }
    }

    private void validateYears(String part, BindingResult bindingResult) {
        boolean invalidYear = false;
        try {
            int year = Integer.parseInt(part);
            if (year <= 0) {
                invalidYear = true;
            }
        } catch (RuntimeException e) {
            invalidYear = true;
        }
        if (invalidYear) {
            bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
        }
    }

    private void validateDays(String part, BindingResult bindingResult) {
        boolean invalidDay = false;
        try {
            int day = Integer.parseInt(part);
            if (day < 1 || day > 31) {
                invalidDay = true;
            }
        } catch (RuntimeException e) {
            invalidDay = true;
        }
        if (invalidDay) {
            bindingResult.rejectValue("birthDay", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
        }
    }


    private void validateBirthYear(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        if (censusEntryCommand.getBirthYear() != null) {
            if (!isPositiveInteger(censusEntryCommand.getBirthYear())) {
                bindingResult.rejectValue("birthYear", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
            }
        }
    }

    private boolean isPositiveInteger(String string) {
        try {
            int Number;
            Number = Integer.parseInt(string);
            return Number > 0;
        } catch (RuntimeException e) {
            return false;
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

