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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandValidatorTypePartTwoTest {

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
    void aNullNumberIsInvalidTest() {
        numberTest(null, "The number cannot be null.");
    }

    @Test
    void anEmptyNumberIsInvalidTest() {
        numberTest(" ", "The number must be a non negative integer.");
    }

    @Test
    void anNegativeNumberIsInvalidTest() {
        numberTest("-1", "The number must be a non negative integer.");
    }

    @Test
    void aRealNumberIsInvalidTest() {
        numberTest("3.15", "The number must be a non negative integer.");
    }

    @Test
    void aNonNumberIsInvalidTest() {
        numberTest("zzz", "The number must be a non negative integer.");
    }


    private void numberTest(String testValue, String error) {
        birthCertificateCommand.setNumber(testValue);
        birthCertificateCommand.setVolume(GetRandomString());
        birthCertificateCommand.setRegistrationAuthority(GetRandomOrganisation());
        commandValidator.validate(birthCertificateCommand, bindingResultMock);


        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("number", stringArgumentCaptor.getValue());
        assertEquals(error, stringArgumentCaptor3.getValue());
    }

    @Test
    void zeroIsAnAValidNumberTest() {
        birthCertificateCommand.setNumber("0");
        birthCertificateCommand.setVolume(GetRandomString());
        birthCertificateCommand.setRegistrationAuthority(GetRandomOrganisation());
        commandValidator.validate(birthCertificateCommand, bindingResultMock);

        verifyNoInteractions(bindingResultMock);

    }


}