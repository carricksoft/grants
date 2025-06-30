/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public interface ValidateTypes {
    void validatePerson(Person person, String field, String message, BindingResult bindingResult);

    void validateOrganisation(Organisation organisation, String field, String message, BindingResult bindingResult);

    void validateCertificateType(CertificateType certificateType, String field, String message, BindingResult bindingResult);

    void validateSex(Sex sex, String fieldName, String message, BindingResult bindingResult);

    void validateNullOrEmptyString(String string, @SuppressWarnings("SameParameterValue") String field, @SuppressWarnings("SameParameterValue") String message, BindingResult bindingResult);

    @SuppressWarnings({"unused", "EmptyMethod"})
    void validatePastDate(String dateString, String fieldName, @SuppressWarnings("SameParameterValue") String nullMessage, String formatMessage, String pastMessage, BindingResult bindingResult);

    @SuppressWarnings({"unused", "EmptyMethod"})
    void validateNonNegativeInteger(String integerString, String fieldName, @SuppressWarnings("SameParameterValue") String nullMessage, String formatMessage, BindingResult bindingResult);

    @SuppressWarnings("EmptyMethod")
    void validatePastDateAndTime(@SuppressWarnings("unused") String dateString, @SuppressWarnings("unused") String fieldName, @SuppressWarnings("unused") String nullMessage, @SuppressWarnings("unused") String formatMessage, @SuppressWarnings("unused") String pastMessage, @SuppressWarnings("unused") BindingResult bindingResult);

    @SuppressWarnings("EmptyMethod")
    void validatePersonAndUntrackedPerson(Person person, String untrackedPerson, String personFieldName, String untrackedFieldName, String message,  BindingResult bindingResult);


    @SuppressWarnings("EmptyMethod")
    void validatePlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult);

    void validateOptionalPlaceAndUntrackedPlace(Place place, String untrackedPlace, String placeFieldName, String untrackedFieldName, String message, BindingResult bindingResult);
}
