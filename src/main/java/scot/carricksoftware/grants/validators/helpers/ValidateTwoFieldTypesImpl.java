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


    @SuppressWarnings("DuplicatedCode")
    @Override
    public void validatePersonAndUntrackedPerson(Person person, String untrackedPerson, String personFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
       boolean error = person == null && (untrackedPerson == null || untrackedPerson.trim().isEmpty());
        if (!(person == null) && untrackedPerson != null &&  !(untrackedPerson.trim().isEmpty())) {
            error = true;
        }
        if (error) {
            bindingResult.rejectValue(personFieldName, ApplicationConstants.EMPTY_STRING, null, message);
            bindingResult.rejectValue(untrackedFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void validatePlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        boolean error = place == null && (untrackedPlace == null || untrackedPlace.trim().isEmpty());
        if (!(place == null) && untrackedPlace != null &&  !(untrackedPlace.trim().isEmpty())) {
            error = true;
        }
        if (error) {
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
