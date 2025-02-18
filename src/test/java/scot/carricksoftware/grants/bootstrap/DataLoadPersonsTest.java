/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DataLoadPersonsTest {


    DataLoadPersons dataLoadPersons;

    @Mock
    PersonService personServiceMock;

    @BeforeEach
    void setUp() {
        dataLoadPersons = new DataLoadPersons(personServiceMock);
    }

    @Test
    void testPeople() {
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);

        when(personServiceMock.save(personCaptor.capture())).thenReturn(new Person());
        dataLoadPersons.load();
        Person[] persons = personCaptor.getAllValues().toArray(new Person[0]);
        assertEquals(2, persons.length);
        assertEquals("Andrew", persons[0].getFirstName());
        assertEquals("Grant", persons[0].getLastName());

        assertEquals("Dorothy", persons[1].getFirstName());
        assertEquals("Bramall", persons[1].getLastName());
    }

}