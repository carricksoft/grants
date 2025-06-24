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
import scot.carricksoftware.grants.capitalisation.people.CapitalisePerson;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PageFormControllerValidationAndValidationTest {

    @SuppressWarnings("unused")
    private PersonFormControllerImpl personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;

    @Mock
    private CapitalisePerson capitalisePersonMock;

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
                capitalisePersonMock,
                personCommandValidatorMock);
    }


    @Test
    public void validationTakesPlaceTest() {
        PersonCommand personCommand = new PersonCommandImpl();
        when(personServiceMock.savePersonCommand(personCommand)).thenReturn(personCommand);

        personController.saveOrUpdate(personCommand, bindingResultMock, modelMock);
        verify(personCommandValidatorMock).validate(personCommand, bindingResultMock);
    }

    @Test
    public void capitalisationTakesPlaceTest() {
        PersonCommand personCommand = new PersonCommandImpl();
        when(personServiceMock.savePersonCommand(personCommand)).thenReturn(personCommand);

        personController.saveOrUpdate(personCommand, bindingResultMock, modelMock);
        verify(capitalisePersonMock).capitalise(personCommand);
    }

}