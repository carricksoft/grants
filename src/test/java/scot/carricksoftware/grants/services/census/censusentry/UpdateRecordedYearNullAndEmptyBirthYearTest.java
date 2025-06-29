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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.enums.census.CensusDate.CENSUS_1881;

@ExtendWith(MockitoExtension.class)
class UpdateRecordedYearNullAndEmptyBirthYearTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;

    @Mock
    private PersonCommand personCommandMock;

    @Mock
    private Person personMock;

    @Mock
    private Census censusMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusEntryCommand censusEntryCommandMock;

    @Mock
    private PersonConverter personConverterMock;

    @BeforeEach
    void setUp() {
        when(personConverterMock.convert(any())).thenReturn(personCommandMock);
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock, personServiceMock);
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusEntryCommandMock.getAge()).thenReturn("80");
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
    }

    @Test
    public void nullTest() {
        doTheTest();
    }

    @Test
    public void emptyTest() {
        when(censusEntryCommandMock.getBirthYear()).thenReturn("");
        doTheTest();
    }

    private void doTheTest() {
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        verify(personCommandMock).setRecordedYearOfBirth("1801");
        verify(personServiceMock).savePersonCommand(personCommandMock);
    }


}