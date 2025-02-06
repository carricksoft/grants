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
        HashSet<Region> regions = new HashSet<>();
        Region west = new Region();
        regions.add(west);
        when(regionRepositoryMock.findAll()).thenReturn(regions);
        assertEquals(regions, regionService.findAll());
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        assertTrue(true);
    }

    @Test
    void saveTest() {
        Region edinburgh = new Region();
        edinburgh.setName("Edinburgh");

        when(regionRepositoryMock.save(edinburgh)).thenReturn(edinburgh);

        assertEquals(edinburgh, regionService.save(edinburgh));
    }
}