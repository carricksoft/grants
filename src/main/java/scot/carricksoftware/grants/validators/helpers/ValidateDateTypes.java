/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.validation.BindingResult;

public interface ValidateDateTypes {

    @SuppressWarnings({"unused", "EmptyMethod"})
    void validatePastDate(String dateString, String fieldName, @SuppressWarnings("SameParameterValue") String nullMessage, String formatMessage, String pastMessage, BindingResult bindingResult);

    @SuppressWarnings("EmptyMethod")
    void validatePastDateAndTime(@SuppressWarnings("unused") String dateString, @SuppressWarnings("unused") String fieldName, @SuppressWarnings("unused") String nullMessage, @SuppressWarnings("unused") String formatMessage, @SuppressWarnings("unused") String pastMessage, @SuppressWarnings("unused") BindingResult bindingResult);

}
