/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonServiceTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @BeforeEach
    void setUp() {
        personService = new PersonServiceImpl(personRepositoryMock);
    }

    @Mock
    Pageable pageableMock;

    @Test
    void findAllTest() {
        HashSet<Person> people = new HashSet<>();

        Person archie = new Person();
        people.add(archie);

        when(personRepositoryMock.findAll(any(Pageable.class))).thenReturn(people);
        assertEquals(people, personRepositoryMock.findAll(pageableMock));
    }

    @Test
    void findAllSortTest() {
        final ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        personService.findAll();
        verify(personRepositoryMock).findAll(pageableCaptor.capture());

        Pageable pageable = pageableCaptor.getValue();
        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(pageable.getSort().getOrderFor("firstName")).getDirection());
        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(pageable.getSort().getOrderFor("lastName")).getDirection());
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        assertTrue(true);
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        Person person = new Person();
        person.setFirstName(GetRandomString());
        person.setLastName(GetRandomString());

        when(personRepositoryMock.save(person)).thenReturn(person);

        assertEquals(person, personService.save(person));
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void deleteTest() {
        assertTrue(true);
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void deleteByIdTest() {
        assertTrue(true);
    }
}