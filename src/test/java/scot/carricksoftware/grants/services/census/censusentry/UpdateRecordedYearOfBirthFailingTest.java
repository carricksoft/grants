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
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.enums.census.CensusDate.CENSUS_1881;

@ExtendWith(MockitoExtension.class)
class UpdateRecordedYearOfBirthFailingTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;

    @Mock
    private Census censusMock;

    @Mock
    private Person personMock;

    @Mock
    private PersonCommand personCommandMock;

    @Mock
    private PersonService personServiceMock;


    @Mock
    private CensusEntryCommand censusEntryCommandMock;

    @Mock
    private PersonConverter personConverterMock;

    @BeforeEach
    void setUp() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock, personServiceMock);
    }


    @Test
    public void theYearOfBirthIsNotUpdatedIfAgeIsInvalidTest() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock, personServiceMock);
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(censusEntryCommandMock.getAge()).thenReturn("3 months");
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        verify(personCommandMock, times(0)).setRecordedYearOfBirth(anyString());
    }


    @Test
    public void theYearOfBirthIsNotResetTest() {
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(personMock.getRecordedYearOfBirth()).thenReturn("1874");
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        verify(personCommandMock, times(0)).setRecordedYearOfBirth(anyString());
    }

    @Test
    public void anExceptionsIsThrownOnNullPersonCommandWithABirthYearTest() {
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusEntryCommandMock.getBirthYear()).thenReturn("1880");
        when(personConverterMock.convert(personMock)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock));
    }

    @Test
    public void anExceptionsIsThrownOnNullPersonCommandWithNoBirthYearTest() {
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(censusEntryCommandMock.getBirthYear()).thenReturn(null);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusEntryCommandMock.getAge()).thenReturn("7");
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
        assertThrows(NullPointerException.class, () -> updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock));
    }


}