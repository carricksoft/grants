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
import scot.carricksoftware.grants.controllers.census.CensusListControllerImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DataLoadCensusITest {


    private CensusListControllerImpl censusListController;
    private final ControllerHelper controllerHelper;
    private final CensusServiceImpl censusService;

    @Autowired
    DataLoadCensusITest(ControllerHelper controllerHelper,
                        CensusEntryServiceImpl censusEntryService,
                        PersonService personService, CensusServiceImpl censusService) {
        this.controllerHelper = controllerHelper;
        this.censusService = censusService;
    }


    @BeforeEach
    void setUp() {
        censusListController = new CensusListControllerImpl(controllerHelper, censusService);
    }


    @Test
    void censusTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(censusListController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.CENSUS_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.CENSUS_LIST));

        List<Census> entries = censusService.getPagedCensuses(0);

        assertEquals(1, entries.size());

    }


}