/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public class ValidateTwoFieldTypesImpl implements ValidateTwoFieldTypes {

    @Override
    public void validatePersonAndUntrackedPerson(Person person, String untrackedPerson, String personFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        @SuppressWarnings("DuplicatedCode") boolean untrackedFound = (untrackedPerson != null && !untrackedPerson.isEmpty());
        if ((person == null && !untrackedFound) || person != null && untrackedFound) {
            bindingResult.rejectValue(personFieldName, ApplicationConstants.EMPTY_STRING, null, message);
            bindingResult.rejectValue(untrackedFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validatePlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        @SuppressWarnings("DuplicatedCode") boolean untrackedFound = (untrackedPlace != null && !untrackedPlace.isEmpty());
        if ((place == null && !untrackedFound) || place != null && untrackedFound) {
            bindingResult.rejectValue(placeFieldName, ApplicationConstants.EMPTY_STRING, null, message);
            bindingResult.rejectValue(untrackedFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        } 
    }

    @Override
    public void validateOptionalPlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        if (!(place == null) && untrackedPlace != null &&  !(untrackedPlace.trim().isEmpty())) {
            bindingResult.rejectValue(placeFieldName, ApplicationConstants.EMPTY_STRING, null, message);
            bindingResult.rejectValue(untrackedFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

}
