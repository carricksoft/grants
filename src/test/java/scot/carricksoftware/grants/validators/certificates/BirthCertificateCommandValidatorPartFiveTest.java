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
import scot.carricksoftware.grants.enums.censusentry.CensusEntrySex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandValidatorPartFiveTest {

    private BirthCertificateCommandPartThreeValidator commandValidator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private BirthCertificateCommand birthCertificateCommand;

    @Mock
    BindingResult bindingResultMock;




    @BeforeEach
    void setUp() {
        commandValidator = new BirthCertificateCommandPartThreeValidator();
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
    void nullSexTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setNumber("99");
        birthCertificateCommand.setVolume("02");
        birthCertificateCommand.setSex(null);
        birthCertificateCommand.setWhereBorn(GetRandomString());
        birthCertificateCommand.setWhenBorn("25/01/1953 01:00");
        birthCertificateCommand.setRegistrationAuthority(GetRandomOrganisation());
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("sex", stringArgumentCaptor.getValue());
        assertEquals("Sex cannot be null.", stringArgumentCaptor3.getValue());
    }

    @Test
    void nullWhereBornTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setNumber("99");
        birthCertificateCommand.setVolume("02");
        birthCertificateCommand.setSex(CensusEntrySex.FEMALE);
        birthCertificateCommand.setWhereBorn(null);
        birthCertificateCommand.setWhenBorn("25/01/1953 01:00");
        birthCertificateCommand.setRegistrationAuthority(GetRandomOrganisation());
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("whereBorn", stringArgumentCaptor.getValue());
        assertEquals("Where born cannot be null.", stringArgumentCaptor3.getValue());
    }

    @Test
    void emptyWhereBornTest() {
        birthCertificateCommand.setNewBorn(GetRandomPerson());
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setNumber("99");
        birthCertificateCommand.setVolume("02");
        birthCertificateCommand.setSex(CensusEntrySex.FEMALE);
        birthCertificateCommand.setWhereBorn("");
        birthCertificateCommand.setWhenBorn("25/01/1953 01:00");
        birthCertificateCommand.setRegistrationAuthority(GetRandomOrganisation());
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);
        birthCertificateCommand.setCertificateSource(GetRandomOrganisation());

        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("whereBorn", stringArgumentCaptor.getValue());
        assertEquals("Where born cannot be null.", stringArgumentCaptor3.getValue());
    }




}