/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceSaveTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @Mock
    PersonConverterImpl personConverterImplMock;

    @Mock
    PersonCommandConverterImpl personCommandConverterImplMock;


    @Before
    public void setUp() {
        personService = new PersonServiceImpl(personRepositoryMock,
                personConverterImplMock,
                personCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        Person person = new Person();
        person.setFirstName(GetRandomString());
        person.setLastName(GetRandomString());

        when(personRepositoryMock.save(person)).thenReturn(person);

        assertEquals(person, personService.save(person));
    }

    @Test
    public void savePersonCommandTest() {
        Person person = GetRandomPerson();
        PersonCommand personCommand = new PersonCommand();
        when(personCommandConverterImplMock.convert(personCommand)).thenReturn(person);
        when(personRepositoryMock.save(person)).thenReturn(person);
        when(personConverterImplMock.convert((person))).thenReturn(personCommand);

        assertEquals(personCommand, personService.savePersonCommand(personCommand));
    }


}