/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public interface ValidateTypes {
    void validatePerson(Person person, String field, String message, BindingResult bindingResult);

    void validateOrganisation(Organisation organisation, String field, String message, BindingResult bindingResult);

    void validateCertificateType(CertificateType certificateType, String field, String message, BindingResult bindingResult);

    void validateSex(Sex sex, String fieldName, String message, BindingResult bindingResult);

    void validateNullOrEmptyString(String string, @SuppressWarnings("SameParameterValue") String field, @SuppressWarnings("SameParameterValue") String message, BindingResult bindingResult);

    @SuppressWarnings({"unused", "EmptyMethod"})
    void validateNonNegativeInteger(String integerString, String fieldName, @SuppressWarnings("SameParameterValue") String nullMessage, String formatMessage, BindingResult bindingResult);


}
