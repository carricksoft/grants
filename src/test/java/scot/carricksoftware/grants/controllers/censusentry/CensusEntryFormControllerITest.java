/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CensusEntryFormControllerITest {

    @SuppressWarnings("unused")
    private CensusEntryFormController censusEntryController;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private CensusEntryCommandConverterImpl censusEntryCommandConverterMock;

    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;
    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @BeforeEach
    void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusServiceMock,
                censusEntryCommandConverterMock,
                censusEntryConverterMock,
                personServiceMock,
                capitalisationMock);
    }

    @Test
    void getNewCensusEntryTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_NEW))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("censusentry/form"));
    }

    @Test
    void PostCensusEntryTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();
        Long id = GetRandomLong();
        CensusEntryCommand censusEntryCommand = new CensusEntryCommand();
        censusEntryCommand.setId(id);
        String expectedViewName = "redirect:/censusEntry/" + id + "/show";


        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.CENSUSENTRY))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));
    }


}