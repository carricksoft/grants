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
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.controllers.people.PersonFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PersonFormControllerSaveOrUpdateTest {

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
    BindingResult bindingResultMock;

    @Autowired
    private PersonCommand personCommand;


    @BeforeEach
    void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        personCommand.setId(id);
        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);
        assertEquals("redirect:/person/4/show", personController.saveOrUpdate(personCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        Long id = 4L;
        personCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);
        assertEquals("person/form", personController.saveOrUpdate(personCommand, bindingResultMock));
    }

    @Test
    void CleaningTakesPlaceTest() {
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(4L);
        personCommand.setFirstName("john");
        personCommand.setLastName("doe");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);
        personController.saveOrUpdate(personCommand, bindingResultMock);
        verify(capitalisationMock).getCapitalisation("john");
        verify(capitalisationMock).getCapitalisation("doe");
    }


}