/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.places.regions.CapitaliseRegionImpl;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.RegionCommandValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegionFormControllerCleansingTest {

    @SuppressWarnings({"unused"})
    private RegionFormControllerImpl regionController;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private RegionCommandConverterImpl regionCommandConverterMock;

    @Mock
    private RegionConverterImpl regionConverterMock;


    @Mock
    private CapitaliseRegionImpl capitaliseRegionMock;


    @Mock
    private RegionCommandValidator regionCommandValidatorMock;

    @Mock
    private Model modelMock;

    @Mock
    private BindingResult bindingResultMock;

    RegionCommand regionCommand;

    @BeforeEach
    public void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitaliseRegionMock,
                regionCommandValidatorMock,
                countryServiceMock);
        regionCommand = new RegionCommandImpl();
    }

    @Test
    public void validationTakesRegionTest() {
        when(regionServiceMock.saveRegionCommand(regionCommand)).thenReturn(regionCommand);
        regionController.saveOrUpdate(regionCommand, bindingResultMock, modelMock);
        verify(regionCommandValidatorMock).validate(regionCommand, bindingResultMock);
    }

    @Test
    public void capitalisationTakesRegionTest() {
        when(regionServiceMock.saveRegionCommand(regionCommand)).thenReturn(regionCommand);
        regionController.saveOrUpdate(regionCommand, bindingResultMock, modelMock);
        verify(capitaliseRegionMock).capitalise(regionCommand);
    }
}