/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.constants.ApplicationConstants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ValidateDateTypesImpl implements ValidateDateTypes {

    @Override
    public void validatePastDate(String dateString, String fieldName, String nullMessage, String formatMessage, String pastMessage, BindingResult bindingResult) {
        if (dateString == null || dateString.trim().isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstants.DATE_FORMAT);
            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                if (date.isAfter(LocalDate.now())) {
                    bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, pastMessage);
                }
            } catch (Exception e) {
                bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, formatMessage);
            }
        }
    }

    @Override
    public void validatePastDateAndTime(String dateString, String fieldName, String nullMessage, String formatMessage, String pastMessage, BindingResult bindingResult) {
        if (dateString == null || dateString.trim().isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstants.DATE_TIME_FORMAT);
            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                if (date.isAfter(LocalDate.now())) {
                    bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, pastMessage);
                }
            } catch (Exception e) {
                bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, formatMessage);
            }
        }
    }


}
