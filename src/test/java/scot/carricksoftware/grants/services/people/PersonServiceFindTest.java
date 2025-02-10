/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.Optional;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SuppressWarnings("CommentedOutCode")
@SpringBootTest
class PersonServiceFindTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @BeforeEach
    void setUp() {
        personService = new PersonServiceImpl(personRepositoryMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

//    @Test
//    void findAllTest() {
//        HashSet<Person> people = new HashSet<>();
//
//        Person archie = new Person();
//        people.add(archie);
//
//        when(personRepositoryMock.findAll()).thenReturn(people);
//        assertEquals(people, personRepositoryMock.findAll(pageableMock));
//    }

//    @Test
//    void findAllSortTest() {
//        final ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
//        personService.findAll();
//        verify(personRepositoryMock).findAll(pageableCaptor.capture());
//
//        Pageable pageable = pageableCaptor.getValue();
//        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(pageable.getSort().getOrderFor("firstName")).getDirection());
//        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(pageable.getSort().getOrderFor("lastName")).getDirection());
//    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        when(personRepositoryMock.findById(id)).thenReturn(Optional.of(person));
        assertEquals(person, personService.findById(id));
    }

    @Test
    void findByIdNullTest() {
        Long id = GetRandomLong();
        when(personRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(personService.findById(id));
    }

}