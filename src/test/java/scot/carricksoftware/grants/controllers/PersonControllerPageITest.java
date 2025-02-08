/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonControllerPageITest {

    private PersonController personController;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        personController = new PersonController(personServiceMock);
    }


    @Test
    void getListPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).findAll();
    }


    @Test
    void getNextPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).findAll('+');
    }
}