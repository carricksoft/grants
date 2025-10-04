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
import scot.carricksoftware.grants.cache.BMDCache;
import scot.carricksoftware.grants.capitalisation.people.CapitalisePerson;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonFormControllerSaveOrUpdateTest {

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
    private Model modelMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PersonCommandValidator personCommandValidatorMock;

    @Mock
    private BMDCache bmdCacheMock;

    @Mock
    private ImageService imageServiceMock;

    private PersonCommand personCommand;


    @BeforeEach
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisePersonMock,
                personCommandValidatorMock,
                bmdCacheMock,
                imageServiceMock);
        personCommand = new PersonCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        personCommand.setId(id);
        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);
        assertEquals("redirect:/person/4/show", personController.saveOrUpdate(personCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        personCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("person/form", personController.saveOrUpdate(personCommand, bindingResultMock, modelMock));
    }

    @Test
    public void cacheIsInvalidatedTest() {
        when(personServiceMock.savePersonCommand(any(PersonCommand.class))).thenReturn(personCommand);
        personController.saveOrUpdate(personCommand, bindingResultMock, modelMock);
        verify(bmdCacheMock).invalidatePeople();
    }

}