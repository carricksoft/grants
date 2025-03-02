/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

@SpringBootTest
public class PersonServiceTest {

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

    @Mock
    Page<Person> pageMock;


    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        personService.deleteById(id);
        verify(personRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(personRepositoryMock.count()).thenReturn(result);
        assertEquals(result, personService.count());
    }

    @Test
    public void getPagedPersonsTest() {
        List<Person> result = new ArrayList<>();
        Person person = GetRandomPerson();
        result.add(person);
        when(pageMock.getContent()).thenReturn(result);
        when(personRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, personService.getPagedPersons(0));
    }


}