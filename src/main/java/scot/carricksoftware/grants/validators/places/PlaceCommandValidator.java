/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.places;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class PlaceCommandValidator {

    public void validate(PlaceCommand placeCommand, BindingResult bindingResult) {
        validateName(placeCommand, bindingResult);
        validateRegion(placeCommand,bindingResult);
    }

    private void validateRegion(PlaceCommand placeCommand, BindingResult bindingResult) {
        if (placeCommand.getRegion() == null) {
            bindingResult.rejectValue("region", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.REGION_IS_NULL);
        }
    }

    public void validateName(PlaceCommand placeCommand, BindingResult bindingResult) {
        if (placeCommand.getName().length() < ApplicationConstants.MINIMUM_NAME_LENGTH) {
            bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.NAME_IS_TOO_SHORT);
        } else {
            if (placeCommand.getName().length() > ApplicationConstants.MAXIMUM_NAME_LENGTH) {
                bindingResult.rejectValue("name", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.NAME_IS_TOO_LONG);
            }
        }
    }


}

