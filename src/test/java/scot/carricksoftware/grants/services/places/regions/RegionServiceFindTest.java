/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.regions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;
import scot.carricksoftware.grants.services.places.RegionService;
import scot.carricksoftware.grants.services.places.RegionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegionServiceFindTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterImplMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterImplMock;

    @Before
    public void setUp() {
        regionService = new RegionServiceImpl(
                regionRepositoryMock,
                regionConverterImplMock,
                regionCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void findByIdTest() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        when(regionRepositoryMock.findById(id)).thenReturn(Optional.of(region));
        assertEquals(region, regionService.findById(id));
    }

    @Test
    public void findByIdNullTest() {
        Long id = GetRandomLong();
        when(regionRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(regionService.findById(id));
    }

    @Test
    public void findAllTest() {
        List<Region> testList = new ArrayList<>();
        Region testRegion = GetRandomRegion();
        testList.add(testRegion);
        when(regionRepositoryMock.findAll())
                .thenReturn(testList);
        assertEquals(testList, regionService.findAll());
        verify(regionRepositoryMock).findAll();
    }

}