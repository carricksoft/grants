/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitaliseRegionTest {

    private CapitaliseRegion capitaliseRegion;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseRegion = new CapitaliseRegionImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseNameTest() {
        RegionCommand regionCommand = new RegionCommandImpl();
        regionCommand.setName("lower");
        when(capitaliseStringMock.capitalise("lower")).thenReturn("Lower");
        capitaliseRegion.capitalise(regionCommand);
        assertEquals("Lower",regionCommand.getName());
    }
}