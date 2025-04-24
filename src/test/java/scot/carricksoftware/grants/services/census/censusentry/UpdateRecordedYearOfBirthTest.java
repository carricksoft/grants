/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.enums.census.CensusDate.CENSUS_1881;

@ExtendWith(MockitoExtension.class)
class UpdateRecordedYearOfBirthTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;

    @Mock
    private Census censusMock;

    @Mock
    private Person personMock;


    @Mock
    CensusEntryCommand censusEntryCommandMock;

    @Mock
    private PersonConverter personConverterMock;

    @BeforeEach
    void setUp() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock);
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
    }

    @Test
    public void theYearOfBirthIsUpdatedTest() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock);
        when(censusEntryCommandMock.getAge()).thenReturn("7");
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
       updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
       verify(personMock).setRecordedYearOfBirth("1874");
    }

    @Test
    public void theYearOfBirthIsNotUpdatedIfAgeIsInvalidTest() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock);
        when(censusEntryCommandMock.getAge()).thenReturn("3 months");
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        verify(personMock, times(0)).setRecordedYearOfBirth(anyString());
    }

    @Test
    public void theYearOfBirthIsNotResetTest() {
        when(personMock.getRecordedYearOfBirth()).thenReturn("1874");
        when(personMock.getRecordedYearOfBirth()).thenReturn("1800");
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        verify(personMock,times(0)).setRecordedYearOfBirth(anyString());
    }


}