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
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceFindTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @Mock
    PersonConverterImpl personConverterImplMock;

    @Mock
    PersonCommandConverterImpl personCommandConverterImplMock;

    @Before
    public void setUp() {
        personService = new PersonServiceImpl(
                personRepositoryMock,
                personConverterImplMock,
                personCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void findByIdTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        when(personRepositoryMock.findById(id)).thenReturn(Optional.of(person));
        assertEquals(person, personService.findById(id));
    }

    @Test
    public void findByIdNullTest() {
        Long id = GetRandomLong();
        when(personRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(personService.findById(id));
    }

    @Test
    public void findAllTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personRepositoryMock.findAll()).thenReturn(personList);
        assertEquals(personList, personService.findAll());
    }

}