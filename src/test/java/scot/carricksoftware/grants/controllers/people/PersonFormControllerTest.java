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
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPersonCommand;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonFormControllerTest {

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
    private Model modelMock;

    @Before
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock);
    }

    @Test
    public void getNewPersonTest() {
        Model model = new ExtendedModelMap();
        assertEquals("person/form", personController.getNewPerson(model));
        assertEquals(PersonCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.PERSON_COMMAND)).getClass());
    }

    @Test
    public void personEditTestEditTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        when(personServiceMock.findById(id)).thenReturn(person);

        assertEquals("person/form", personController.personEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PERSON_COMMAND, person);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        PersonCommand personCommand = GetRandomPersonCommand();

        when(personServiceMock.findById(id)).thenReturn(person);
        when(personConverterMock.convert(person)).thenReturn(personCommand);
        assertEquals("person/form", personController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PERSON_COMMAND, personCommand);
    }


}