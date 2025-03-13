/*
 * Copyright (c) Andrew Grant of Carrick Software 13/03/2025, 15:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class RegionCommandValidator {

    public void validate(RegionCommand regionCommand, BindingResult bindingResult) {
        if (regionCommand.getName().length() < ApplicationConstants.MINIMUM_NAME_LENGTH) {
            bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.NAME_IS_TOO_SHORT);
        } else {
            if (regionCommand.getName().length() > ApplicationConstants.MAXIMUM_NAME_LENGTH) {
                bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.NAME_IS_TOO_LONG);
            }
        }
    }
}

