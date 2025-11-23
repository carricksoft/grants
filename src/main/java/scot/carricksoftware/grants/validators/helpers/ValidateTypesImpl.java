/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import java.util.Locale;

@Component
public class ValidateTypesImpl implements ValidateTypes {

    @Override
    public void validatePerson(Person person, String fieldName, String message, BindingResult bindingResult) {
        if (person == null) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }
    }

    @Override
    public void validateImage(Image image, String fieldName, String message, BindingResult bindingResult) {
        if (image == null) {
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
    public void validateNonNegativeInteger(String integerString, String fieldName, String nullMessage, String formatMessage, String negativeMessage, BindingResult bindingResult) {
        if (integerString == null || integerString.isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        } else {
            try {
                int test = Integer.parseInt(integerString);
                if (test < 0) {
                    bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, negativeMessage);
                }
            } catch (NumberFormatException e) {
                bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, formatMessage);
            }
        }
    }

    @Override
    public void validateNonNegativeAsteriskInteger(String integerString, String fieldName, String nullMessage, String formatMessage, String negativeMessage, BindingResult bindingResult) {
        if (integerString != null && !integerString.isEmpty()) {
            int pos = integerString.lastIndexOf('*');
                if (pos != -1) {
                    String newString = integerString.substring(0, pos);
                    validateNonNegativeInteger(newString, fieldName, nullMessage, formatMessage, negativeMessage, bindingResult);
                } else {
                    validateNonNegativeInteger(integerString, fieldName, nullMessage, formatMessage, negativeMessage, bindingResult);
                }
        } else {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        }

    }

    @Override
    public void validateIntegerRange(String integerString,
                                     Integer lowValue, Integer highValue, String fieldName,
                                     String nullMessage, String formatMessage, String rangeMessage,
                                     BindingResult bindingResult) {
        if (integerString == null || integerString.isEmpty()) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        } else {
            try {
                int test = Integer.parseInt(integerString);
                if (test < lowValue || test > highValue) {
                    bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, rangeMessage);
                }
            } catch (NumberFormatException e) {
                bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, formatMessage);
            }
        }
    }


    @Override
    public void validateIntegerAsteriskRange(String integerString,
                                           Integer lowValue, Integer highValue, String fieldName,
                                           String nullMessage, String formatMessage, String rangeMessage,
                                           BindingResult bindingResult) {
        if (integerString != null && !integerString.isEmpty()) {
            int pos = integerString.lastIndexOf('*');
            if (pos != -1) {
                String newString = integerString.substring(0, pos);
                validateIntegerRange(newString, lowValue,highValue,fieldName,nullMessage,formatMessage,rangeMessage,bindingResult);
            } else {
                validateIntegerRange(integerString, lowValue,highValue,fieldName,nullMessage,formatMessage,rangeMessage,bindingResult);
            }
        } else {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, nullMessage);
        }


    }

    @Override
    public void validateFileType(String fileName, String fieldName, String[] allowedFileExtensions, String message, BindingResult bindingResult) {
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase(Locale.ROOT);
        boolean validExtension = false;
        for (String allowedFileExtension : allowedFileExtensions) {
            if (allowedFileExtension.equals(extension)) {
                validExtension = true;
                break;
            }
        }
        if (!validExtension) {
            bindingResult.rejectValue(fieldName, ApplicationConstants.EMPTY_STRING, null, message);
        }

    }


}
