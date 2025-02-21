/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.capitalisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.CapitalisationImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CapitalisationLengthTest {

    private Capitalisation capitalisation;

    @BeforeEach
    void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    void lowLengthTest() {
        assertEquals("ab", capitalisation.getCapitalisation("ab"));
    }

    @Test
    void topLengthTest() {
        assertEquals("Abc", capitalisation.getCapitalisation("abc"));
    }

    @Test
    void highLengthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Abcd", capitalisation.getCapitalisation("abcd"));
    }

}
