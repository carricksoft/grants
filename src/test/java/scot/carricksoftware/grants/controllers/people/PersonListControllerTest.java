/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.*;

@SpringBootTest
@RunWith(SpringRunner.class)
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

    @Before
    public void setUp() {
        controller = new PersonListControllerImpl(controllerHelperMock, personServiceImplMock);
    }

    @Test
    public void getListPageTest() {
        when(personServiceImplMock.getPagedPersons(0)).thenReturn(personListMock);
        assertEquals("person/list", controller.getPagedPeople(modelMock, 0));
        verify(modelMock).addAttribute("people", personListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(personServiceImplMock).getPagedPersons(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/people", controller.personDelete(Long.toString(id)));
        verify(personServiceImplMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personServiceImplMock.getPagedPersons(0)).thenReturn(personList);

        assertEquals("person/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("people", personList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personServiceImplMock.getPagedPersons(0)).thenReturn(personList);

        controller.getFirstPage(modelMock);
        assertEquals("person/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("people", personList);
    }

}
