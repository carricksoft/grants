/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonListControllerTest {

    private PersonListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PersonServiceImpl personServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Person> personListMock;

    @BeforeEach
    public void setUp() {
        controller = new PersonListControllerImpl(controllerHelperMock, personServiceImplMock);
    }

    @Test
    void getListPageTest() {
        when(personServiceImplMock.getPagedPersons(0)).thenReturn(personListMock);
        assertEquals("person/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("people", personListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

}
