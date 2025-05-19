/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.censusentry;


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

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorBirthDayDayTest {

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
    public void noSlashTest() {
        censusEntryCommand.setBirthDay("2501");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void noPartsTest() {
        censusEntryCommand.setBirthDay("/");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void invalidBirthDayTest() {
        censusEntryCommand.setBirthDay("z/04");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void tooLowDayTest() {
        censusEntryCommand.setBirthDay("0/04");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void tooHighDayTest() {
        censusEntryCommand.setBirthDay("32/04");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void lowDayTest() {
        censusEntryCommand.setBirthDay("1/04");
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


    @Test
    public void highDayTest() {
        censusEntryCommand.setBirthDay("31/04");
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

}