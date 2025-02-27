/*
 * Copyright (c)  27 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.censusentry.CensusEntryListControllerImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DataLoadCensusTest {


    private CensusEntryListControllerImpl censusEntryController;
    private final ControllerHelper controllerHelper;
    private final CensusEntryServiceImpl censusEntryService;
    private final PersonService personService;
    private final CensusService censusService;

    @Autowired
    DataLoadCensusTest(ControllerHelper controllerHelper, CensusEntryServiceImpl censusEntryService, PersonService personService, CensusService censusService) {
        this.controllerHelper = controllerHelper;
        this.censusEntryService = censusEntryService;
        this.personService = personService;
        this.censusService = censusService;
    }


    @BeforeEach
    void setUp() {
        censusEntryController = new CensusEntryListControllerImpl(controllerHelper, censusEntryService);
    }


    @Test
    void entryTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusEntryController).build();
        Person person = personService.findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUSENTRY_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUSENTRY_LIST));

        List<CensusEntry> entries = censusEntryService.getPagedCensusEntries(0);
        Census census = censusService.findById(1L);

        assertEquals(1, entries.size());
        assertEquals(person, entries.get(0).getPerson());
        assertEquals(census.toString(), entries.get(0).getCensus().toString());
        assertEquals(person.toString(), entries.get(0).getOtherPerson());
    }


}