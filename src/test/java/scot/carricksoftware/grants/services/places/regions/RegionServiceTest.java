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
import org.springframework.data.domain.Page;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegionServiceTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterImplMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterImplMock;

    @Mock
    Page<Region> regionPageMock;


    @Before
    public void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock,
                regionConverterImplMock,
                regionCommandConverterImplMock);
    }


    @Test
    public void testDeleteByIdTest() {
        Long id = GetRandomLong();
        regionService.deleteById(id);
        verify(regionRepositoryMock).deleteById(id);
    }

    @Test
    public void countTest() {
        Long count = GetRandomLong();
        when(regionRepositoryMock.count()).thenReturn(count);
        assertEquals((long) count, regionService.count());
    }

    @Test
    public void getPagedTest() {
        List<Region> list = new ArrayList<>();
        list.add(GetRandomRegion());
        when(regionPageMock.getContent()).thenReturn(list);
        when(regionRepositoryMock.findAll(any(Pageable.class))).thenReturn(regionPageMock);

        assertEquals(list, regionService.getPagedRegions(1));
    }

}