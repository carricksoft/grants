/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        dataLoadPersons.load();
        verify(personServiceMock, times(2)).save(any(Person.class));
    }

}