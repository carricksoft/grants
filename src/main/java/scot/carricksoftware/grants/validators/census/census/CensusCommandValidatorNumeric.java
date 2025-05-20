/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.census;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;


public interface CensusCommandValidatorNumeric {

    @SuppressWarnings("unused")
    void validate(CensusCommand censusCommand, BindingResult bindingResult);
}

