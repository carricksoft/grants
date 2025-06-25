/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitalisePersonTest {

    private CapitalisePerson capitalisePerson;

    private PersonCommand personCommand;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePerson = new CapitalisePersonImpl(capitaliseStringMock);
        personCommand = new PersonCommandImpl();
        when(capitaliseStringMock.capitalise("first")).thenReturn("First");
        when(capitaliseStringMock.capitalise("last")).thenReturn("Last");
    }

    @Test
    void nameTest() {
        personCommand.setFirstName("first");
        personCommand.setLastName("last");
        capitalisePerson.capitalise(personCommand);
        assertEquals("First", personCommand.getFirstName());
        assertEquals("Last", personCommand.getLastName());
    }
}