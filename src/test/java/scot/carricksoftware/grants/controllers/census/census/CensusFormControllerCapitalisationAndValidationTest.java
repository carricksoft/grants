/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.census.census.CapitaliseCensus;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.census.census.CensusCommandValidatorImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CensusFormControllerCapitalisationAndValidationTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    CensusCommandValidatorImpl censusCommandValidatorImplMock;

    @Mock
    private CapitaliseCensus capitaliseCensusMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    private CensusCommand censusCommand;

    @BeforeEach
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandValidatorImplMock,
                capitaliseCensusMock,
                censusConverterMock,
                placeServiceMock);
        censusCommand = new CensusCommandImpl();
    }

    @Test
    public void validationTakesPlaceTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        censusController.saveOrUpdate(censusCommand, bindingResultMock, modelMock);
        verify(censusCommandValidatorImplMock).validate(censusCommand, bindingResultMock);
    }

    @Test
    public void capitalisationTakesPlaceTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        censusController.saveOrUpdate(censusCommand, bindingResultMock, modelMock);
        verify(capitaliseCensusMock).capitalise(censusCommand);
    }


}