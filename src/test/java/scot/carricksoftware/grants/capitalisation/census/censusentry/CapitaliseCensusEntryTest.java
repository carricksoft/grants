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

    @BeforeEach
    void setUp() {
        capitaliseCensusEntry = new CapitaliseCensusEntryImpl(capitaliseStringMock);
    }

    @Test
    void nameTest() {
        CensusEntryCommand censusEntryCommand = new CensusEntryCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
        censusEntryCommand.setName("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getName());
    }

    @Test
    void industryOrServiceTest() {
        CensusEntryCommand censusEntryCommand = new CensusEntryCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
        censusEntryCommand.setIndustryOrService("lower");
        capitaliseCensusEntry.capitalise(censusEntryCommand);
        assertEquals("Lower", censusEntryCommand.getIndustryOrService());
    }
}