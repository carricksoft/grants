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
        boolean untrackedFound = (untrackedPerson != null && !untrackedPerson.isEmpty());
        if ((person == null && !untrackedFound) || person != null && untrackedFound) {
            reportError(personFieldName, untrackedFieldName, message, bindingResult);
        }
    }

    @Override
    public void validateOptionalPersonAndUntrackedPerson(Person person, String untrackedPerson, String personFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        if (person != null && (untrackedPerson != null  && !untrackedPerson.isEmpty())) {
            reportError(personFieldName, untrackedFieldName, message, bindingResult);
        }
    }

    @Override
    public void validatePlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
    boolean untrackedFound = (untrackedPlace != null && !untrackedPlace.isEmpty());
        if ((place == null && !untrackedFound) || place != null && untrackedFound) {
            reportError(placeFieldName, untrackedFieldName, message, bindingResult);
        } 
    }

    @Override
    public void validateOptionalPlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
      if (place!= null && (untrackedPlace != null && !untrackedPlace.isEmpty())) {
          reportError(placeFieldName, untrackedFieldName, message, bindingResult);
      }
    }

    @Override
    public void validateNotSamePerson(Person firstPerson, Person secondPerson, String firstPersonFieldName, String secondPersonFieldName, String message, BindingResult bindingResult) {
        if (secondPerson != null && firstPerson == secondPerson) {
            bindingResult.rejectValue(firstPersonFieldName, ApplicationConstants.EMPTY_STRING, null, message);
            bindingResult.rejectValue(secondPersonFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    private void reportError(String personFieldName, String untrackedFieldName, String message, BindingResult bindingResult) {
        bindingResult.rejectValue(personFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        bindingResult.rejectValue(untrackedFieldName, ApplicationConstants.EMPTY_STRING, null, message);
    }

}
