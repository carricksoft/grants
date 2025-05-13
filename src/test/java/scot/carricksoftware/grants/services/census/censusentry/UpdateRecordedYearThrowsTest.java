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
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class UpdateRecordedYearThrowsTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;


    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusEntryCommand censusEntryCommandMock;

    @Mock
    private PersonConverter personConverterMock;

    @Mock
    private Person personMock;


    @BeforeEach
    void setUp() {
        updateRecordedYearOfBirth = new UpdateRecordedYearOfBirthImpl(personConverterMock, personServiceMock);
    }

    @Test
    public void noPersonIsThrownTest() {
        Exception exception = assertThrows(NullPointerException.class,
                () -> updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock));

        String expectedMessage = "Person is null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void noPersonCommandIsThrownTest() {
        when(censusEntryCommandMock.getPerson()).thenReturn(personMock);
        when(censusEntryCommandMock.getBirthYear()).thenReturn(GetRandomString());
        when(personConverterMock.convert(personMock)).thenReturn(null);
        Exception exception = assertThrows(NullPointerException.class,
                () -> updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock));

        String expectedMessage = "Person Command is null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



}