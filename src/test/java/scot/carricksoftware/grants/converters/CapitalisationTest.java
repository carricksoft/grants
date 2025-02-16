/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CapitalisationTest {

    private Capitalisation capitalisation;

    @BeforeEach
    void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    void firstTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("smith"));
    }
}