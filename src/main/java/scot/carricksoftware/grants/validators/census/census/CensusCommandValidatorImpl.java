/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.census;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;

@Component
public class CensusCommandValidatorImpl implements CensusCommandValidator {

    private final CensusCommandValidatorNonNumeric validatorNonNumeric;
    private final CensusCommandValidatorNumeric validatorNumeric;


    public CensusCommandValidatorImpl(CensusCommandValidatorNonNumeric validatorNonNumeric,
                                      CensusCommandValidatorNumeric validatorNumeric) {
        this.validatorNonNumeric = validatorNonNumeric;
        this.validatorNumeric = validatorNumeric;
    }

    public void validate(CensusCommand censusCommand,
                         BindingResult bindingResult) {
        validatorNonNumeric.validate(censusCommand, bindingResult);
        validatorNumeric.validate(censusCommand, bindingResult);
    }
}

