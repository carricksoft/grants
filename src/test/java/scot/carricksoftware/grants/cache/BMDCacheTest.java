/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BMDCacheTest {

    @Mock
    PersonService personServiceMock;

    private BMDCache cache;

    @BeforeEach
    void setUp() {
        cache = new BMDCacheImpl(personServiceMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(cache);
    }
}