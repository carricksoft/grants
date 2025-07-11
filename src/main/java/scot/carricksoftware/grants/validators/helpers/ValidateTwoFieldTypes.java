/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public interface ValidateTwoFieldTypes {

    void validatePersonAndUntrackedPerson(Person person, String untrackedPerson, String personFieldName, String untrackedFieldName, String message,  BindingResult bindingResult);

    void validatePlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult);

    void validateOptionalPlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult);
}
