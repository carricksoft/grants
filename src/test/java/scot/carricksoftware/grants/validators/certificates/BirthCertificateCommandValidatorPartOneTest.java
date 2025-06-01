/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandValidatorPartOneTest {

    private BirthCertificateCommandPartOneValidator commandValidator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private BirthCertificateCommand birthCertificateCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        commandValidator = new BirthCertificateCommandPartOneValidator();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        birthCertificateCommand = new BirthCertificateCommandImpl();
    }

    @Test
    public void certificateNumberTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("certificateNumber", stringArgumentCaptor.getValue());
        assertEquals("The certificate number cannot be null.", stringArgumentCaptor3.getValue());

    }

    @Test
    public void certificateSourceTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateNumber(GetRandomString());
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateDate("25/01/1953");

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("certificateSource", stringArgumentCaptor.getValue());
        assertEquals("The certificate source cannot be null.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void certificateInvalidDateTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateNumber(GetRandomString());
        birthCertificateCommand.setCertificateDate(GetRandomString());
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        when(bindingResultMock.hasErrors()).thenReturn(false);
        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("certificateDate", stringArgumentCaptor.getValue());
        assertEquals("The certificate date is invalid or of the wrong format.", stringArgumentCaptor3.getValue());
    }


}