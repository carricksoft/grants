/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.census.censusentry.CapitaliseCensusEntry;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.census.censusentry.UpdateRecordedYearOfBirth;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.census.censusentry.CensusEntryCommandValidatorImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CensusEntryFormControllerUpdateRecordedBirthDateTest {

    @SuppressWarnings("unused")
    private CensusEntryFormControllerImpl censusEntryController;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    CensusEntryCommandValidatorImpl censusEntryCommandValidatorImplMock;

    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;

    @Mock
    private CapitaliseCensusEntry capitaliseCensusEntryMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private UpdateRecordedYearOfBirth updateRecordedYearOfBirthMock;

    CensusEntryCommand censusEntryCommand;

    @BeforeEach
    public void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusEntryCommandValidatorImplMock,
                censusEntryConverterMock,
                capitaliseCensusEntryMock,
                personServiceMock,
                censusServiceMock,
                updateRecordedYearOfBirthMock);
        censusEntryCommand = new CensusEntryCommandImpl();
    }

    @Test
    public void PersonReportedDatesAreUpdatedTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);
        censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock, modelMock);
        verify(updateRecordedYearOfBirthMock).updateRecordedYearOfBirth(censusEntryCommand);
    }


}