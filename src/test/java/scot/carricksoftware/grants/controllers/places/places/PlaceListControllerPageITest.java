/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

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
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class PlaceListControllerPageITest {

    @SuppressWarnings("unused")
    private PlaceListControllerImpl placeController;
    private final ControllerHelper controllerHelper;

    @Mock
    private PlaceServiceImpl placeServiceMock;

    @Autowired
    PlaceListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        placeController = new PlaceListControllerImpl(controllerHelper, placeServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PLACE_LIST));
        verify(placeServiceMock).getPagedCountries(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PLACE_LIST));
        verify(placeServiceMock).getPagedCountries(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("place/list"));
        verify(placeServiceMock).getPagedCountries(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("place/list"));
        verify(placeServiceMock).getPagedCountries(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("place/list"));
        verify(placeServiceMock).getPagedCountries(0);
    }

    @Test
    void placeDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/places"));
        verify(placeServiceMock).deleteById(id);
    }


}