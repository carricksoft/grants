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
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.enums.census.CensusDate.CENSUS_1881;

@ExtendWith(MockitoExtension.class)
@ExtendWith(OutputCaptureExtension.class)
class UpdateRecordedYearOfBirthInvalidAgeTest {

    private UpdateRecordedYearOfBirth updateRecordedYearOfBirth;

    @Mock
    private Census censusMock;

    @Mock
    private Person personMock;

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
        when(censusEntryCommandMock.getCensus()).thenReturn(censusMock);
        when(censusEntryCommandMock.getAge()).thenReturn("e");
        when(censusMock.getCensusDate()).thenReturn(CENSUS_1881);
    }


    @Test
    public void theYearOfBirthIsInvalidIsLoggedTest(CapturedOutput capturedOutput) {
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(censusEntryCommandMock);
        assertTrue(capturedOutput.getOut().contains("Age cannot be parsed"));
    }

}