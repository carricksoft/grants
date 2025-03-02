/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.regions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;
import scot.carricksoftware.grants.services.places.RegionService;
import scot.carricksoftware.grants.services.places.RegionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;

@SpringBootTest
public class RegionServiceTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterImplMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterImplMock;


    @Before
    public void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock,
                regionConverterImplMock,
                regionCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Region> pageMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        regionService.deleteById(id);
        verify(regionRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(regionRepositoryMock.count()).thenReturn(result);
        assertEquals(result, regionService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Region> result = new ArrayList<>();
        Region region = GetRandomRegion();
        result.add(region);
        when(pageMock.getContent()).thenReturn(result);
        when(regionRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, regionService.getPagedCountries(0));
    }

}