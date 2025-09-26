/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class BMDPeopleCacheTest {

    @Mock
    PersonService personServiceMock;

    @Mock
    PlaceService placeServiceMock;

    @Mock
    OrganisationService organisationServiceMock;

    private BMDCache cache;

    private List<Person> peopleList = null;

    @BeforeEach
    void setUp() {
        peopleList = new ArrayList<>();
        peopleList.add(GetRandomPerson());
        when(personServiceMock.findAll()).thenReturn(peopleList);
        cache = new BMDCacheImpl(personServiceMock, placeServiceMock, organisationServiceMock);
    }

    @Test
    void nullPeopleTest() {
        assertEquals(peopleList, cache.getPeople());
        verify(personServiceMock).findAll();
    }

    @Test
    void alreadyExistsTest() {
        assertEquals(peopleList, cache.getPeople());
        assertEquals(peopleList, cache.getPeople());
        verify(personServiceMock, times(1)).findAll();
    }

    @Test
    void invalidateTest() {
        assertEquals(peopleList, cache.getPeople());
        cache.invalidatePeople();
        assertEquals(peopleList, cache.getPeople());
        verify(personServiceMock, times(2)).findAll();
    }
}