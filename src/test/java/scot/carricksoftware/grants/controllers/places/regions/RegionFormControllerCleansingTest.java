/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class RegionFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private RegionFormControllerImpl regionController;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private RegionCommandConverterImpl regionCommandConverterMock;

    @Mock
    private RegionConverterImpl regionConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    RegionCommand regionCommandMock;

    @Mock
    BindingResult bindingResultMock;


    @BeforeEach
    void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock);
    }


    @Test
    void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(regionServiceMock.saveRegionCommand(any())).thenReturn(regionCommandMock);
        when(regionCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        regionController.saveOrUpdate(regionCommandMock, bindingResultMock);
        verify(regionCommandMock).setName(uName);
    }


}