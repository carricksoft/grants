/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.capitalisation;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.CapitalisationImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CapitalisationTest {

    private Capitalisation capitalisation;

    @Before
    public void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    public void firstTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("Smith"));
    }

    @Test
    public void secondTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("smith"));
    }

    @Test
    public void thirdTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("SMITH"));
    }

    @Test
    public void fourthTest() {
        assertEquals("Smith Jones", capitalisation.getCapitalisation("smith jones"));
    }

    @Test
    public void fifthTest() {
        assertEquals("Smith-Jones", capitalisation.getCapitalisation("smith-jones"));
    }

    @Test
    public void sixthTest() {
        assertEquals("McSmith", capitalisation.getCapitalisation("mcSmith"));
    }

    @Test
    public void seventhTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Macsmith", capitalisation.getCapitalisation("macsmith"));
    }

    @Test
    public void eighthTest() {
        assertEquals("MacSmith", capitalisation.getCapitalisation("macSmith"));
    }

    @Test
    public void ninthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("McSmith", capitalisation.getCapitalisation("mcsmith"));
    }

    @Test
    public void nullTest() {
        assertEquals("", capitalisation.getCapitalisation(null));
    }


}
