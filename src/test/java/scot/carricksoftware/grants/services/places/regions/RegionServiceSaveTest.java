/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;
import scot.carricksoftware.grants.services.places.RegionService;
import scot.carricksoftware.grants.services.places.RegionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class RegionServiceSaveTest {

    RegionService regionService;

    @Mock
    RegionRepository regionRepositoryMock;

    @Mock
    RegionConverterImpl regionConverterImplMock;

    @Mock
    RegionCommandConverterImpl regionCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        regionService = new RegionServiceImpl(regionRepositoryMock,
                regionConverterImplMock,
                regionCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        Region region = new Region();
        region.setName(GetRandomString());

        when(regionRepositoryMock.save(region)).thenReturn(region);

        assertEquals(region, regionService.save(region));
    }

    @Test
    void saveRegionCommandTest() {
        Region region = GetRandomRegion();
        RegionCommand regionCommand = new RegionCommand();
        when(regionCommandConverterImplMock.convert(regionCommand)).thenReturn(region);
        when(regionRepositoryMock.save(region)).thenReturn(region);
        when(regionConverterImplMock.convert((region))).thenReturn(regionCommand);

        assertEquals(regionCommand, regionService.saveRegionCommand(regionCommand));
    }


}