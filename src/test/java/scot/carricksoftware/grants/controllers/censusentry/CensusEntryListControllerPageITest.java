/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

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
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CensusEntryListControllerPageITest {

    @SuppressWarnings("unused")
    private CensusEntryListControllerImpl censusEntryController;
    private final ControllerHelper controllerHelper;

    @Mock
    private CensusEntryServiceImpl censusEntryServiceMock;

    @Autowired
    CensusEntryListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        censusEntryController = new CensusEntryListControllerImpl(controllerHelper, censusEntryServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUSENTRY_LIST));
        verify(censusEntryServiceMock).getPagedCensusEntries(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUSENTRY_LIST));
        verify(censusEntryServiceMock).getPagedCensusEntries(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("censusentry/list"));
        verify(censusEntryServiceMock).getPagedCensusEntries(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("censusentry/list"));
        verify(censusEntryServiceMock).getPagedCensusEntries(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("censusentry/list"));
        verify(censusEntryServiceMock).getPagedCensusEntries(0);
    }

    @Test
    void censusEntryDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/censusEntries"));
        verify(censusEntryServiceMock).deleteById(id);
    }


}