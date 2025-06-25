/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.census.censusentry;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseCensusEntryTest {

    private CapitaliseCensusEntry capitaliseCensusEntry;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private CensusEntryCommand censusEntryCommand;

    @BeforeEach
    void setUp() {
        capitaliseCensusEntry = new CapitaliseCensusEntryImpl(capitaliseStringMock);
        censusEntryCommand = new CensusEntryCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void nameTest() {
        censusEntryCommand.setName("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getName());
    }

    @Test
    void industryOrServiceTest() {
        censusEntryCommand.setIndustryOrService("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getIndustryOrService());
    }

    @Test
    void whereBornTest() {
        censusEntryCommand.setWhereBorn("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getWhereBorn());
    }

    @Test
    void personalOccupationTest() {
        censusEntryCommand.setPersonalOccupation("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getPersonalOccupation());
    }

    @Test
    void notesTest() {
        censusEntryCommand.setNotes("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getNotes());
    }
}