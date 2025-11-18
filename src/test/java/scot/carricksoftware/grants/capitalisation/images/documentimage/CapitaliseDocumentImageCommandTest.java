/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.documentimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseDocumentImageCommandTest {

    private CapitaliseDocumentImageCommand capitaliseDocumentImageCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseDocumentImageCommand = new CapitaliseDocumentImageCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        DocumentImageCommand documentImageCommand = new DocumentImageCommandImpl();
        documentImageCommand.setCaption(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitaliseDocumentImageCommand.capitalise(documentImageCommand);
        assertEquals("Upper",documentImageCommand.getCaption());
    }
}