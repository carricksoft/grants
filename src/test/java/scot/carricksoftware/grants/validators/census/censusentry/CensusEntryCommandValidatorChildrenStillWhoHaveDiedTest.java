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
class CensusEntryCommandValidatorChildrenStillWhoHaveDiedTest {

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
        censusEntryCommand.setChildrenWhoHaveDied("-5");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenWhoHaveDied", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void ZeroTest() {
        censusEntryCommand.setChildrenWhoHaveDied("0");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenWhoHaveDied", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotIntegerTest() {
        censusEntryCommand.setChildrenWhoHaveDied("3.14");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenWhoHaveDied", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }

    @Test
    public void NotANumberTest() {
        censusEntryCommand.setChildrenWhoHaveDied("zzz");
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("childrenWhoHaveDied", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.FIELD_NOT_NEGATIVE_INTEGER);
    }


}