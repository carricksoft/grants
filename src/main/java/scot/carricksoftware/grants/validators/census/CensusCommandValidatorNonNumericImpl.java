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
public class CensusCommandValidatorNonNumericImpl  {

    public void validate(CensusCommand censusCommand, BindingResult bindingResult) {
        validateDate(censusCommand, bindingResult);
        validateTotalRoomsAndInhabitedRooms(censusCommand, bindingResult);
        validateTotalRoomsAndRoomsWithWindows(censusCommand, bindingResult);
    }

    private void validateTotalRoomsAndRoomsWithWindows(CensusCommand censusCommand, BindingResult bindingResult) {
        if ( censusCommand.getTotalRooms()!= null && !censusCommand.getTotalRooms().isEmpty()) {
            if ( censusCommand.getRoomsWithWindows()!= null && !censusCommand.getRoomsWithWindows().isEmpty()) {
                bindingResult.rejectValue("totalRooms", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.TOTAL_ROOMS_AND_ROOMS_WITH_WINDOWS_CANNOT_COEXIST);
                bindingResult.rejectValue("roomsWithWindows", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.TOTAL_ROOMS_AND_ROOMS_WITH_WINDOWS_CANNOT_COEXIST);

            }
        }
    }

    private void validateTotalRoomsAndInhabitedRooms(CensusCommand censusCommand, BindingResult bindingResult) {
        if ( censusCommand.getTotalRooms()!= null && !censusCommand.getTotalRooms().isEmpty()) {
            if ( censusCommand.getInhabitedRooms()!= null && !censusCommand.getInhabitedRooms().isEmpty()) {
                bindingResult.rejectValue("totalRooms", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.TOTAL_ROOMS_AND_INHABITED_ROOMS_CANNOT_COEXIST);
                bindingResult.rejectValue("inhabitedRooms", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.TOTAL_ROOMS_AND_INHABITED_ROOMS_CANNOT_COEXIST);

            }
        }
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

