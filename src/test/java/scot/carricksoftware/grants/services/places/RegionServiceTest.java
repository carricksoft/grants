/*
 * Copyright (c)  05 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegionServiceTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @BeforeEach
    void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock);
    }


    @Test
    void findAllTest() {
        HashSet<Region> countries = new HashSet<>();
        Region scotland = new Region();
        countries.add(scotland);
        when(regionRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, regionService.findAll());
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        assertTrue(true);
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        assertTrue(true);
    }
}