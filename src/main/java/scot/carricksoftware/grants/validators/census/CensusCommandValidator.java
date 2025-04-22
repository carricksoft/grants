/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class CensusCommandValidator {

    public void validate(CensusCommand censusCommand, BindingResult bindingResult) {
        validateDate(censusCommand, bindingResult);
        validateRoomsInhabited(censusCommand, bindingResult);
        validateRoomsWithWindows(censusCommand, bindingResult);
    }

    private void validateRoomsWithWindows(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getRoomsWithWindows())) {
            bindingResult.rejectValue("roomsWithWindows", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
    }

    private void validateRoomsInhabited(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getInhabitedRooms())) {
            bindingResult.rejectValue("inhabitedRooms", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
    }

    private boolean notANonNegativeInteger(String field) {
        if (field == null || field.isEmpty()) {
            return false;
        } else {
            try {
                int number = Integer.parseInt(field);
                if (number < 0) {
                   return true;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    private void validateDate(CensusCommand censusCommand, BindingResult bindingResult) {
        if (censusCommand.getCensusDate() == null) {
            bindingResult.rejectValue("date", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.DATE_IS_NULL);
        }
        if (censusCommand.getBoundaryType() == null) {
            bindingResult.rejectValue("boundaryType", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.BOUNDARY_TYPE_IS_NULL);
        }
        if (censusCommand.getPlace() == null) {
            bindingResult.rejectValue("place", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PLACE_IS_NULL);
        }

    }
}

