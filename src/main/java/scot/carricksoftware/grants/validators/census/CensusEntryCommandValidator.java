/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;


public interface CensusEntryCommandValidator {

    @SuppressWarnings("unused")
    void validate(CensusEntryCommand censusEntryCommand, BindingResult bindingResult);

}

