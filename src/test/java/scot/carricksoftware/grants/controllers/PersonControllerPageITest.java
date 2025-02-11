/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

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
import scot.carricksoftware.grants.controllers.people.PersonListControllerImpl;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;


@SpringBootTest
class PersonControllerPageITest {

    @SuppressWarnings("unused")
    private PersonListControllerImpl personController;
    private final ControllerHelper controllerHelper;

    @Mock
    private PersonServiceImpl personServiceMock;

    @Autowired
    PersonControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        personController = new PersonListControllerImpl(controllerHelper, personServiceMock);
    }

    @Test
    void getListPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(0);
    }

    @Test
    void getNextPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(1);
    }

    @Test
    void getLastPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(anyInt());
    }

    @Test
    void getPreviousPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(0);
    }

    @Test
    void getFirstPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(0);
    }


}