/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;

public interface ValidateTypes {
    void validatePerson(Person person, String field, String message, BindingResult bindingResult);

    void validateOrganisation(Organisation organisation, String field, String message, BindingResult bindingResult);

    void validateNullOrEmptyString(String string, @SuppressWarnings("SameParameterValue") String field, @SuppressWarnings("SameParameterValue") String message, BindingResult bindingResult);
}
