/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

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
import scot.carricksoftware.grants.controllers.census.CensusListControllerImpl;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CensusListControllerPageITest {

    @SuppressWarnings("unused")
    private CensusListControllerImpl censusController;
    private final ControllerHelper controllerHelper;

    @Mock
    private CensusServiceImpl censusServiceMock;

    @Autowired
    CensusListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        censusController = new CensusListControllerImpl(controllerHelper, censusServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUS_LIST));
        verify(censusServiceMock).getPagedCensuses(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUS_LIST));
        verify(censusServiceMock).getPagedCensuses(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("census/list"));
        verify(censusServiceMock).getPagedCensuses(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("census/list"));
        verify(censusServiceMock).getPagedCensuses(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("census/list"));
        verify(censusServiceMock).getPagedCensuses(0);
    }

    @Test
    void censusDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/censuses"));
        verify(censusServiceMock).deleteById(id);
    }


}