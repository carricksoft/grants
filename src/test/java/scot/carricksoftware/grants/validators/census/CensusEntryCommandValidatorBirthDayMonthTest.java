/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 09:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorBirthDayMonthTest {

    private CensusEntryCommandValidatorImpl validator;

    private CensusEntryCommand censusEntryCommand;


    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusEntryCommandValidatorImpl();
        censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setCensus(GetRandomCensus());
        censusEntryCommand.setPerson(GetRandomPerson());
    }


    @Test
    public void invalidMonthTest() {
        censusEntryCommand.setBirthDay("15/z");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void tooLowMonthTest() {
        censusEntryCommand.setBirthDay("15/-3");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void tooHighMonthTest() {
        censusEntryCommand.setBirthDay("15/13");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void lowMonthTest() {
        censusEntryCommand.setBirthDay("1/1");
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


    @Test
    public void highMonthTest() {
        censusEntryCommand.setBirthDay("31/12");
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

}