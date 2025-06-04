/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartTwoValidatorTest {

    private BirthCertificateCommandPartTwoValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartTwoValidatorImpl(validateTypesMock);
    }

    @Test
    void validateRegistrationNumberTest() {
        String number = GetRandomString();
        when(birthCertificateCommandMock.getNumber()).thenReturn(number);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateNonNegativeInteger(number, "number", "The number cannot be null.", "The number must be a non negative integer.", bindingResultMock);
    }

    @Test
    void validateVolumeTest() {
        String number = GetRandomString();
        when(birthCertificateCommandMock.getVolume()).thenReturn(number);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(number, "volume", "The volume cannot be null.", bindingResultMock);
    }

    @Test
    void validateRegistrationAuthorityTest() {
        Organisation organisation = GetRandomOrganisation();
        when(birthCertificateCommandMock.getRegistrationAuthority()).thenReturn(organisation);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateOrganisation(organisation, "certificateSource", "The registration authority cannot be null.", bindingResultMock);
    }

}