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
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PageFormControllerValidationTest {

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
    public void saveOrUpdateValidationTest() {
        PersonCommand personCommand = new PersonCommandImpl();
        personCommand.setFirstName(GetRandomString());
        personCommand.setLastName(GetRandomString());
        personCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(personServiceMock.savePersonCommand(personCommand)).thenReturn(personCommand);

        personController.saveOrUpdate(personCommand, bindingResultMock, modelMock);

        verify(personCommandValidatorMock).validate(personCommand, bindingResultMock);
    }


}