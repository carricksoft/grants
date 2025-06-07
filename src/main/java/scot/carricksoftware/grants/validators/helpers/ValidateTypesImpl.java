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
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ValidateTypesImpl implements ValidateTypes {

    @Override
    public void validatePerson(Person person, String fieldName, String message, BindingResult bindingResult) {
        if (person == null) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateOrganisation(Organisation organisation, String fieldName, String message, BindingResult bindingResult) {
        if (organisation == null) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateCertificateType(CertificateType certificateType, String fieldName, String message, BindingResult bindingResult) {
        if (certificateType == null) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateSex(Sex sex, String fieldName, String message, BindingResult bindingResult) {
        if (sex == null) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateNullOrEmptyString(String string, String fieldName, @SuppressWarnings("SameParameterValue") String message, BindingResult bindingResult) {
        if (string == null || string.trim().isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

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
    public void validateNonNegativeInteger(String integerString, String fieldName, @SuppressWarnings("SameParameterValue") String nullMessage, String formatMessage, BindingResult bindingResult) {
        if (integerString == null || integerString.isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        } else {
            try {
                int test = Integer.parseInt(integerString);
                if (test < 0) {
                    bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, formatMessage);
                }
            } catch (NumberFormatException e) {
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

}
