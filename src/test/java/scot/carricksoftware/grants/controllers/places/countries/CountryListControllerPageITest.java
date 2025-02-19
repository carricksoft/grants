/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

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
import scot.carricksoftware.grants.controllers.places.CountryListControllerImpl;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CountryListControllerPageITest {

    @SuppressWarnings("unused")
    private CountryListControllerImpl countryController;
    private final ControllerHelper controllerHelper;

    @Mock
    private CountryServiceImpl countryServiceMock;

    @Autowired
    CountryListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        countryController = new CountryListControllerImpl(controllerHelper, countryServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.COUNTRY_LIST));
        verify(countryServiceMock).getPagedCountries(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.COUNTRY_LIST));
        verify(countryServiceMock).getPagedCountries(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("country/list"));
        verify(countryServiceMock).getPagedCountries(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("country/list"));
        verify(countryServiceMock).getPagedCountries(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("country/list"));
        verify(countryServiceMock).getPagedCountries(0);
    }

    @Test
    void countryDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/countries"));
        verify(countryServiceMock).deleteById(id);
    }


}