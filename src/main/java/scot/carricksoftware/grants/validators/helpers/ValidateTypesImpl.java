/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class ValidateTypesImpl implements ValidateTypes {

    @Override
    public void validatePerson(Person person, String field, String message, BindingResult bindingResult) {
        if (person == null ) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }
}
