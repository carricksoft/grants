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
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BMDPeopleCacheTest {

    @Mock
    PersonService personServiceMock;

    private BMDCache cache;

    @BeforeEach
    void setUp() {
        cache = new BMDCacheImpl(personServiceMock);
    }

    @Test
    void nullPeopleTest() {
        cache.getPeople();
        verify(personServiceMock).findAll();
    }

    @Test
    void alreadyExistsTest() {
        cache.getPeople();
        cache.getPeople();
        verify(personServiceMock, times(1)).findAll();
    }

    @Test
    void invalidateTest() {
        cache.getPeople();
        cache.invalidatePeople();
        cache.getPeople();
        verify(personServiceMock, times(2)).findAll();
    }
}