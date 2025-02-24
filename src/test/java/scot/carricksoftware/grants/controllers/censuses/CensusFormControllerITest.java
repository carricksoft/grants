/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.controllers.census.CensusFormController;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CensusFormControllerITest {

    @SuppressWarnings("unused")
    private CensusFormController censusController;


    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusCommandConverterImpl censusCommandConverterMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @BeforeEach
    void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                placeServiceMock,
                capitalisationMock);
    }

    @Test
    void PostCensusTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusController).build();
        Long id = GetRandomLong();
        CensusCommand censusCommand = new CensusCommand();
        censusCommand.setId(id);
        String expectedViewName = "redirect:/census/" + id + "/show";


        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.CENSUS))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));


    }


}