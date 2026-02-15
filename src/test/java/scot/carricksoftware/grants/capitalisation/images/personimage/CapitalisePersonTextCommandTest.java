/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.personimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitalisePersonTextCommandTest {

    private CapitalisePersonImageCommand capitalisePersonImageCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePersonImageCommand = new CapitalisePersonImageCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        PersonImageCommand personImageCommand = new PersonImageCommandImpl();
        personImageCommand.setCaption(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitalisePersonImageCommand.capitalise(personImageCommand);
        assertEquals("Upper",personImageCommand.getCaption());
    }
}