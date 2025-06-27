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
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomInteger;

@ExtendWith(MockitoExtension.class)
class UpdateRecordedYearOfBirthViaBirthYearTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;


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
    }

    @Test
    public void theYearOfBirthIsUpdatedTest() {
        Integer yearOfBirth = GetRandomInteger();
        when(censusEntryCommandMock.getBirthYear()).thenReturn(yearOfBirth.toString());
        when(personMock.getRecordedYearOfBirth()).thenReturn(null);

        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);

        verify(personCommandMock).setRecordedYearOfBirth(yearOfBirth.toString());
    }


}