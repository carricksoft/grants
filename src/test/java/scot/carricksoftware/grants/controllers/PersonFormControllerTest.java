/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.people.PersonFormControllerImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PersonFormControllerTest {

    @SuppressWarnings("unused")
    private PersonFormControllerImpl personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;

    PersonFormControllerTest() {
    }

    @BeforeEach
    void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock);
    }

    @Test
    void NewPersonSetsTheAttributeTest() {
        Model model = new ExtendedModelMap();
        personController.getNewPerson(model);
        assertEquals(PersonCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.PERSON_COMMAND)).getClass());
    }


}