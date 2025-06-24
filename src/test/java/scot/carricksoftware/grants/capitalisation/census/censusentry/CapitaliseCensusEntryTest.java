/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.census.censusentry;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CapitaliseCensusEntryTest {

    private CapitaliseCensusEntry capitaliseCensusEntry;

    @BeforeEach
    void setUp() {
        capitaliseCensusEntry = new CapitaliseCensusEntryImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(capitaliseCensusEntry);
    }
}