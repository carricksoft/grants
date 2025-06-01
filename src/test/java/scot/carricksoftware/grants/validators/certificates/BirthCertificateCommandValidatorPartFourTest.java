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
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandValidatorPartFourTest {

    private BirthCertificateCommandPartTwoValidator commandValidator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private BirthCertificateCommand birthCertificateCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        commandValidator = new BirthCertificateCommandPartTwoValidator();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        birthCertificateCommand = new BirthCertificateCommandImpl();
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateNumber(Long.toString(GetRandomLong()));
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());
    }

    @Test
    void nullRegistrationAuthorityTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setNumber("99");
        birthCertificateCommand.setVolume("10");
        birthCertificateCommand.setRegistrationAuthority(null);
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("registrationAuthority", stringArgumentCaptor.getValue());
        assertEquals("The registration authority cannot be null.", stringArgumentCaptor3.getValue());
    }

}