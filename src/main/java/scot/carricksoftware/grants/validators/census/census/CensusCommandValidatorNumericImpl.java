/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.census;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class CensusCommandValidatorNumericImpl {

    public void validate(CensusCommand censusCommand, BindingResult bindingResult) {

        validateRoomsInhabited(censusCommand, bindingResult);
        validateRoomsWithWindows(censusCommand, bindingResult);
        validateTotalRooms(censusCommand, bindingResult);
        validateRoomsOccupied(censusCommand, bindingResult);
        validateUninhabitedHouses(censusCommand, bindingResult);
        validateInhabitedHouses(censusCommand, bindingResult);

    }


    private void validateTotalRooms(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getTotalRooms())) {
            bindingResult.rejectValue("totalRooms", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
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

    private void validateRoomsOccupied(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getRoomsOccupied())) {
            bindingResult.rejectValue("roomsOccupied", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
    }

    private void validateUninhabitedHouses(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getUninhabitedHouses())) {
            bindingResult.rejectValue("uninhabitedHouses", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
        }
    }

    private void validateInhabitedHouses(CensusCommand censusCommand, BindingResult bindingResult) {
        if (notANonNegativeInteger(censusCommand.getInhabitedHouses())) {
            bindingResult.rejectValue("inhabitedHouses", ApplicationConstants.EMPTY_STRING,
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


}

