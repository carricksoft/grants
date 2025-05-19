/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.censusentry;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;


public interface CensusEntryCommandValidator {

    @SuppressWarnings("unused")
    void validate(CensusEntryCommand censusEntryCommand, BindingResult bindingResult);

}

