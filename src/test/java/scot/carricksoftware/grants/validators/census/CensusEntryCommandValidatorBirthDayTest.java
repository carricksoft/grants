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
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorBirthDayTest {

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
    public void NoSlashTest() {
        censusEntryCommand.setBirthDay("2501");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void NoPartsTest() {
        censusEntryCommand.setBirthDay("/");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void NegativeDaysTest() {
        censusEntryCommand.setBirthDay("-12/85");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void TooHighDaysTest() {
        censusEntryCommand.setBirthDay("32/85");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void NonValidDaysTest() {
        censusEntryCommand.setBirthDay("z/85");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void ExcessiveDaysTest() {
        censusEntryCommand.setBirthDay("55/85");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void NegativeYearsTest() {
        censusEntryCommand.setBirthDay("11/-7");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }

    @Test
    public void NonValidYearsTest() {
        censusEntryCommand.setBirthDay("11/zz");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTHDAY_INCORRECT_FORMAT);
    }











}