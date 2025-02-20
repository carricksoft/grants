/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.RegionService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegionCommand;


@SpringBootTest
class RegionFormControllerTest {

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
    private Model modelMock;


    @BeforeEach
    void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock);
    }

    @Test
    void getNewRegionTest() {
        Model model = new ExtendedModelMap();
        assertEquals("region/form", regionController.getNewRegion(model));
        assertEquals(RegionCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.REGION_COMMAND)).getClass());
    }

    @Test
    void regionEditTestEditTest() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        when(regionServiceMock.findById(id)).thenReturn(region);

        assertEquals("region/form", regionController.regionEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.REGION_COMMAND, region);
    }

    @Test
    void showByIdTest() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        RegionCommand regionCommand = GetRandomRegionCommand();

        when(regionServiceMock.findById(id)).thenReturn(region);
        when(regionConverterMock.convert(region)).thenReturn(regionCommand);
        assertEquals("region/form", regionController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.REGION_COMMAND, regionCommand);
    }

}