/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class RegionFormControllerSaveOrUpdateTest {

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
    BindingResult bindingResultMock;

    @Autowired
    private RegionCommand regionCommand;


    @BeforeEach
    void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        regionCommand.setId(id);
        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);
        assertEquals("redirect:/region/4/show", regionController.saveOrUpdate(regionCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        Long id = 4L;
        regionCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);
        assertEquals("region/form", regionController.saveOrUpdate(regionCommand, bindingResultMock));
    }

    @Test
    void CleaningTakesPlaceTest() {
        RegionCommand regionCommand = new RegionCommand();
        regionCommand.setId(4L);
        regionCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);
        regionController.saveOrUpdate(regionCommand, bindingResultMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}