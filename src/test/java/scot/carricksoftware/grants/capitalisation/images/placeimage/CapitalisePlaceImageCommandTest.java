/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.placeimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitalisePlaceImageCommandTest {

    private CapitalisePlaceImageCommand capitalisePlaceImageCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePlaceImageCommand = new CapitalisePlaceImageCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        PlaceImageCommand placeImageCommand = new PlaceImageCommandImpl();
        placeImageCommand.setCaption(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitalisePlaceImageCommand.capitalise(placeImageCommand);
        assertEquals("Upper",placeImageCommand.getCaption());
    }
}