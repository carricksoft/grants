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

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorBirthYearTest {

    private CensusEntryCommandValidatorImpl validator;

    private CensusEntryCommand censusEntryCommand;


    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusEntryCommandValidatorImpl();
        censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setCensus(GetRandomCensus());
    }

    @Test
    public void NegativeTest() {
        censusEntryCommand.setBirthYear("-5");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthYear", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void ZeroTest() {
        censusEntryCommand.setBirthYear("0");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthYear", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotIntegerTest() {
        censusEntryCommand.setBirthYear("3.14");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthYear", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotANumberTest() {
        censusEntryCommand.setBirthYear("zzz");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthYear", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }



}