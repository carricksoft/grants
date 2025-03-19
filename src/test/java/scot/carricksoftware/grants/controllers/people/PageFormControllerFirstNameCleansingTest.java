/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.PersonCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PageFormControllerFirstNameCleansingTest {

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

    @Mock
    PersonCommandValidator personCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock,
                personCommandValidatorMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(personServiceMock.savePersonCommand(any())).thenReturn(personCommandMock);
        when(personCommandMock.getFirstName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        personController.saveOrUpdate(personCommandMock, bindingResultMock, modelMock);
        verify(personCommandMock).setFirstName(uName);
    }

    @Test
    public void saveOrUpdateValidationTest() {
        String name = "goat";
        String uName = "Goat";
        when(personServiceMock.savePersonCommand(any())).thenReturn(personCommandMock);
        when(personCommandMock.getFirstName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        personController.saveOrUpdate(personCommandMock, bindingResultMock, modelMock);
        verify(personCommandValidatorMock).validate(personCommandMock, bindingResultMock);
    }

}