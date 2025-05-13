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
class CensusEntryCommandValidatorChildrenStillAliveTest {

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
        censusEntryCommand.setChildrenStillAlive("-5");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenStillAlive", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void ZeroTest() {
        censusEntryCommand.setChildrenStillAlive("0");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenStillAlive", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotIntegerTest() {
        censusEntryCommand.setChildrenStillAlive("3.14");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenStillAlive", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotANumberTest() {
        censusEntryCommand.setChildrenStillAlive("zzz");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenStillAlive", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }


}