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


class CapitalisationTest {

    private Capitalisation capitalisation;

    @BeforeEach
    void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    void firstTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("Smith"));
    }

    @Test
    void secondTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("smith"));
    }

    @Test
    void thirdTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("SMITH"));
    }

    @Test
    void fourthTest() {
        assertEquals("Smith Jones", capitalisation.getCapitalisation("smith jones"));
    }

    @Test
    void fifthTest() {
        assertEquals("Smith-Jones", capitalisation.getCapitalisation("smith-jones"));
    }

    @Test
    void sixthTest() {
        assertEquals("McSmith", capitalisation.getCapitalisation("mcSmith"));
    }

    @Test
    void seventhTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Macsmith", capitalisation.getCapitalisation("macsmith"));
    }

    @Test
    void eighthTest() {
        assertEquals("MacSmith", capitalisation.getCapitalisation("macSmith"));
    }

    @Test
    void ninthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("McSmith", capitalisation.getCapitalisation("mcsmith"));
    }

    @Test
    void nullTest() {
        assertEquals("", capitalisation.getCapitalisation(null));
    }


}
