/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.placetext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitalisePlaceTextCommandTest {

    private CapitalisePlaceTextCommand capitalisePlaceTextCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePlaceTextCommand = new CapitalisePlaceTextCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        PlaceTextCommand placeTextCommand = new PlaceTextCommandImpl();
        placeTextCommand.setHeading(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitalisePlaceTextCommand.capitalise(placeTextCommand);
        assertEquals("Upper",placeTextCommand.getHeading());
    }
}