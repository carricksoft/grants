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

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.enums.census.CensusDate.CENSUS_1881;

@ExtendWith(MockitoExtension.class)
class UpdateCertifiedYearOfBirthPassingTest {

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
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(personConverterMock.convert(personMock)).thenReturn(personCommandMock);
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
    }

    @Test
    public void theYearOfBirthIsUpdatedTest() {
        when(censusEntryCommandMock.getAge()).thenReturn("7");
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);

        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);

        verify(personCommandMock).setRecordedYearOfBirth("1874");
    }


}