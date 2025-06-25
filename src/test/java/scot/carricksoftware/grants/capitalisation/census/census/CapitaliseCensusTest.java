/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.census.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitaliseCensusTest {

    private CapitaliseCensus capitaliseCensus;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseCensus = new CapitaliseCensusImpl(capitaliseStringMock);
    }

    @Test
    void filledInByTest() {
        CensusCommand censusCommand = new CensusCommandImpl();
        when(capitaliseStringMock.capitalise("lower")).thenReturn("Lower");
        censusCommand.setFilledInBy("lower");
        capitaliseCensus.capitalise(censusCommand);
        assertEquals("Lower", censusCommand.getFilledInBy());
    }
}