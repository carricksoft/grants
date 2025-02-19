/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

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
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class PersonListControllerPageITest {

    @SuppressWarnings("unused")
    private PersonListControllerImpl personController;
    private final ControllerHelper controllerHelper;

    @Mock
    private PersonServiceImpl personServiceMock;

    @Autowired
    PersonListControllerPageITest(ControllerHelper controllerHelper) {
        this.controllerHelper = controllerHelper;
    }

    @BeforeEach
    void setUp() {
        personController = new PersonListControllerImpl(controllerHelper, personServiceMock);
    }

    @Test
    void getListPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_LIST))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(0);
    }

    @Test
    void getNextPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_NEXT))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(ViewConstants.PEOPLE_LIST));
        verify(personServiceMock).getPagedPersons(1);
    }

    @Test
    void getLastPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_FF))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person/list"));
        verify(personServiceMock).getPagedPersons(anyInt());
    }

    @Test
    void getPreviousPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_PREVIOUS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person/list"));
        verify(personServiceMock).getPagedPersons(0);
    }

    @Test
    void getFirstPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PEOPLE_REWIND))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person/list"));
        verify(personServiceMock).getPagedPersons(0);
    }

    @Test
    void personDeleteTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        Long id = GetRandomLong();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PERSON_DELETE, id + ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/people"));
        verify(personServiceMock).deleteById(id);
    }


}