/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.appendixtext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.capitalisation.text.appendixText.CapitaliseAppendixTextCommand;
import scot.carricksoftware.grants.capitalisation.text.appendixText.CapitaliseAppendixTextCommandImpl;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseAppendixTextCommandTest {

    private CapitaliseAppendixTextCommand capitaliseAppendixTextCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseAppendixTextCommand = new CapitaliseAppendixTextCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        AppendixTextCommand appendixTextCommand = new AppendixTextCommandImpl();
        appendixTextCommand.setHeading(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitaliseAppendixTextCommand.capitalise(appendixTextCommand);
        assertEquals("Upper",appendixTextCommand.getHeading());
    }
}