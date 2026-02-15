/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.persontext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitalisePersonTextCommandTest {

    private CapitalisePersonTextCommand capitalisePersonTextCommand;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePersonTextCommand = new CapitalisePersonTextCommandImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        PersonTextCommand personTextCommand = new PersonTextCommandImpl();
        personTextCommand.setHeading(lower);

        when(capitaliseStringMock.capitalise(lower)).thenReturn("Upper");

        capitalisePersonTextCommand.capitalise(personTextCommand);
        assertEquals("Upper",personTextCommand.getHeading());
    }
}