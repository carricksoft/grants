/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryFormControllerITest {

    @SuppressWarnings("unused")
    private CountryFormController countryController;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private CountryCommandConverterImpl countryCommandConverterMock;

    @Mock
    private CountryConverterImpl countryConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Before
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock);
    }

    @Test
    public void getNewCountryTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.COUNTRY_NEW))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("country/form"));
    }

    @Test
    public void PostCountryTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
        Long id = GetRandomLong();
        CountryCommand countryCommand = new CountryCommand();
        countryCommand.setId(id);
        String expectedViewName = "redirect:/country/" + id + "/show";


        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.COUNTRY))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));
    }


}