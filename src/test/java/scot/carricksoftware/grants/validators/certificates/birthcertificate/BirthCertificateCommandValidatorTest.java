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

    private BirthCertificateCommandValidator commandValidator;

    @Mock
    private BirthCertificateCommandPartOneValidator partOneValidatorMock;

    @Mock
    private BirthCertificateCommandPartTwoValidator partTwoValidatorMock;

    @Mock
    private BirthCertificateCommandPartThreeValidator partThreeValidatorMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @BeforeEach
    void setUp() {
        commandValidator = new BirthCertificateCommandValidatorImpl(
                partOneValidatorMock,
                partTwoValidatorMock,
                partThreeValidatorMock);
    }

    @Test
    public void partOneIsCalledTest() {
        commandValidator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(partOneValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
    }

    @Test
    public void partTwoIsCalledTest() {
        commandValidator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(partTwoValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
    }

    @Test
    public void partThreeIsCalledTest() {
        commandValidator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(partThreeValidatorMock).validate(birthCertificateCommandMock, bindingResultMock);
    }



}