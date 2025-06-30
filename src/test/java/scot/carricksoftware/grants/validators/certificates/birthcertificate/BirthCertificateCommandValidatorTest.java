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

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandValidatorTest {

    private BirthCertificateCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BirthCertificateCommandPartOneValidator partOneValidatorMock;

    @Mock
    private BirthCertificateCommandPartTwoValidator partTwoValidatorMock;

    @Mock
    private BirthCertificateCommandPartThreeValidator partThreeValidatorMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandValidatorImpl(partOneValidatorMock, partTwoValidatorMock, partThreeValidatorMock);
    }

    @Test
    void validateTest() {
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(partOneValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
        verify(partTwoValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
        verify(partThreeValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
    }
}