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
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private PersonFormControllerImpl personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    PersonCommand personCommandMock;

    @Mock
    BindingResult bindingResultMock;


    @Before
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock);
    }

    @Test
    public void saveOrUpdateCleansingFirstNameTest() {
        String name = "goat";
        String uName = "Goat";
        when(personServiceMock.savePersonCommand(any())).thenReturn(personCommandMock);
        when(personCommandMock.getFirstName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        personController.saveOrUpdate(personCommandMock, bindingResultMock);

        verify(personCommandMock).setFirstName(uName);
    }

    @Test
    public void saveOrUpdateCleansingLastNameTest() {
        String name = "goat";
        String uName = "Goat";
        when(personServiceMock.savePersonCommand(any())).thenReturn(personCommandMock);
        when(personCommandMock.getLastName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        personController.saveOrUpdate(personCommandMock, bindingResultMock);
        verify(personCommandMock).setLastName(uName);
    }


}