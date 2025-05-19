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
import scot.carricksoftware.grants.validators.census.CensusEntryCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorBirthYearAndAgeTest {

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
    public void BirthYearAndAgeMustNotCoexistTest() {
        censusEntryCommand.setBirthYear("1880");
        censusEntryCommand.setAge("80");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthYear", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);
        verify(bindingResultMock).rejectValue("age", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTH_YEAR_AND_AGE_CANNOT_COEXIST);
    }


    @Test
    public void BirthDayAndAgeMustNotCoexistTest() {
        censusEntryCommand.setBirthDay("25/01");
        censusEntryCommand.setAge("80");
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("birthDay", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);
        verify(bindingResultMock).rejectValue("age", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.BIRTH_DAY_AND_AGE_CANNOT_COEXIST);
    }


}