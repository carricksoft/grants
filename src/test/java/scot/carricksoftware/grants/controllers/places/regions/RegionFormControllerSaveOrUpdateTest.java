/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RegionFormControllerSaveOrUpdateTest {

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
    private BindingResult bindingResultMock;


    @Before
    public void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock);
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        RegionCommand regionCommand = new RegionCommand();
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("region/form", regionController.saveOrUpdate(regionCommand, bindingResultMock));
    }
}