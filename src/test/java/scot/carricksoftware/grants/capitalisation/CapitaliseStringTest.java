/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CapitaliseStringTest {

    private CapitaliseString capitaliseString;

    @BeforeEach
    void setUp() {
        capitaliseString = new CapitaliseStringImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(capitaliseString);
    }

    @Test
    public void firstTest() {
        assertEquals("Smith", capitaliseString.capitalise("Smith"));
    }

    @Test
    public void secondTest() {
        assertEquals("Smith", capitaliseString.capitalise("smith"));
    }

    @Test
    public void thirdTest() {
        assertEquals("Smith", capitaliseString.capitalise("SMITH"));
    }

    @Test
    public void fourthTest() {
        assertEquals("Smith Jones", capitaliseString.capitalise("smith jones"));
    }

    @Test
    public void fifthTest() {
        assertEquals("Smith-Jones", capitaliseString.capitalise("smith-jones"));
    }

    @Test
    public void sixthTest() {
        assertEquals("McSmith", capitaliseString.capitalise("mcSmith"));
    }

    @Test
    public void seventhTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Macsmith", capitaliseString.capitalise("macsmith"));
    }

    @Test
    public void eighthTest() {
        assertEquals("MacSmith", capitaliseString.capitalise("macSmith"));
    }

    @Test
    public void ninthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("McSmith", capitaliseString.capitalise("mcsmith"));
    }

    @Test
    public void nullTest() {
        assertEquals("", capitaliseString.capitalise(null));
    }
}