/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.appendixImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.capitalisation.images.appendiximage.CapitaliseAppendixImageCommand;
import scot.carricksoftware.grants.capitalisation.images.appendiximage.CapitaliseAppendixImageCommandImpl;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseAppendixImageCommandTest {

    private CapitaliseAppendixImageCommand capitaliseAppendixImageCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseAppendixImageCommand = new CapitaliseAppendixImageCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        AppendixImageCommand appendixImageCommand = new AppendixImageCommandImpl();
        appendixImageCommand.setCaption(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitaliseAppendixImageCommand.capitalise(appendixImageCommand);
        assertEquals("Upper",appendixImageCommand.getCaption());
    }
}