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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.places.RegionServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class RegionListControllerPageITest {

    @SuppressWarnings("unused")
    private RegionListControllerImpl regionController;
    private final ControllerHelper controllerHelper;

    @Mock
    private RegionServiceImpl regionServiceMock;

    @Autowired
    RegionListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        regionController = new RegionListControllerImpl(controllerHelper, regionServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.REGION_LIST));
        verify(regionServiceMock).getPagedCountries(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.REGION_LIST));
        verify(regionServiceMock).getPagedCountries(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("region/list"));
        verify(regionServiceMock).getPagedCountries(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("region/list"));
        verify(regionServiceMock).getPagedCountries(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("region/list"));
        verify(regionServiceMock).getPagedCountries(0);
    }

    @Test
    void regionDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regionController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.REGION_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/regions"));
        verify(regionServiceMock).deleteById(id);
    }


}