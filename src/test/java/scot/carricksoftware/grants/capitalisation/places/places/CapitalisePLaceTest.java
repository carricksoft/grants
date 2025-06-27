/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitalisePLaceTest {

    private CapitalisePlace capitalisePlace;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePlace = new CapitalisePlaceImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseNameTest() {
        PlaceCommand placeCommand = new PlaceCommandImpl();
        placeCommand.setName("lower");
        when(capitaliseStringMock.capitalise("lower")).thenReturn("Lower");
        capitalisePlace.capitalise(placeCommand);
        assertEquals("Lower", placeCommand.getName());
    }
}