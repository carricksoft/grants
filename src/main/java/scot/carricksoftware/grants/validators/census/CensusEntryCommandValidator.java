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
public class CensusEntryCommandValidator {

    private static final Logger logger = LogManager.getLogger(CensusEntryCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        logger.debug("censusEntryCommandValidator::validate");
        validateCensus(censusEntryCommand, bindingResult);
        validateNameAndPerson(censusEntryCommand, bindingResult);
        validateBirthYear(censusEntryCommand, bindingResult);
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

