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
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.people.PersonFormController;
import scot.carricksoftware.grants.controllers.people.PersonFormControllerImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class PersonFormControllerITest {

    @SuppressWarnings("unused")
    private PersonFormController personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;


    @BeforeEach
    void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock);
    }

    @Test
    void getNewPersonTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PERSON_NEW))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PERSON_FORM));
    }

    @Test
    void PostPersonTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        Long id = 4L;
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(id);
        String expectedViewName = MappingConstants.REDIRECT
                + "/person/show"
                + "/" + id;


        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.PERSON))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));
    }


}