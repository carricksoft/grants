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


    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartTwoValidatorImpl(validateTypesMock);
        when(birthCertificateCommandMock.getNumber()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getVolume()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getRegistrationAuthority()).thenReturn(GetRandomOrganisation());
    }

    @Test
    void validatorAreCalledTest() {
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateNonNegativeInteger(birthCertificateCommandMock.getNumber(),
                "number",
                "The number cannot be null.",
                "The number must be a non negative integer.",
                bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(birthCertificateCommandMock.getVolume(),
                "volume", "The volume cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(birthCertificateCommandMock.getRegistrationAuthority(),
                "registrationAuthority", "The registration authority cannot be null.", bindingResultMock);
    }
}