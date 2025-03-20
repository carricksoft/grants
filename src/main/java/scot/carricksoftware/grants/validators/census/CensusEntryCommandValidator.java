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

@SuppressWarnings("unused")
@Component
public class CensusEntryCommandValidator {

    private static final Logger logger = LogManager.getLogger(CensusEntryCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        logger.debug("censusEntryCommandValidator::validate");
        validateNameAndPerson(censusEntryCommand, bindingResult);
    }

    @SuppressWarnings("unused")
    private void validateNameAndPerson(CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
            logger.debug("censusEntryCommandValidator::validateNameAndPerson");
       // This will be updated later
    }
}

