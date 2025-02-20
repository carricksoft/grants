/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class RegionFormControllerITest {

    @SuppressWarnings("unused")
    private RegionFormController regionController;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private RegionCommandConverterImpl regionCommandConverterMock;

    @Mock
    private RegionConverterImpl regionConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @BeforeEach
    void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock);
    }

    @Test
    void getNewRegionTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_NEW))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("region/form"));
    }

    @Test
    void PostRegionTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();
        Long id = GetRandomLong();
        RegionCommand regionCommand = new RegionCommand();
        regionCommand.setId(id);
        String expectedViewName = "redirect:/region/" + id + "/show";


        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.REGION))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));
    }


}