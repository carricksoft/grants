/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;

@Component
public class ValidateTypesImpl implements ValidateTypes {

    @Override
    public void validatePerson(Person person, String field, String message, BindingResult bindingResult) {
        if (person == null ) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateOrganisation(Organisation organisation, String field, String message, BindingResult bindingResult) {
        if (organisation == null ) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateNullOrEmptyString(String string, @SuppressWarnings("SameParameterValue") String field, @SuppressWarnings("SameParameterValue") String message, BindingResult bindingResult) {
        if (string == null||string.isEmpty()) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }
}
