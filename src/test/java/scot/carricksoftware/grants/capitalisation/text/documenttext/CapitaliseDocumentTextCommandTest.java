/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.documenttext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseDocumentTextCommandTest {

    private CapitaliseDocumentTextCommand capitaliseDocumentTextCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseDocumentTextCommand = new CapitaliseDocumentTextCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        DocumentTextCommand documentTextCommand = new DocumentTextCommandImpl();
        documentTextCommand.setHeading(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitaliseDocumentTextCommand.capitalise(documentTextCommand);
        assertEquals("Upper",documentTextCommand.getHeading());
    }
}