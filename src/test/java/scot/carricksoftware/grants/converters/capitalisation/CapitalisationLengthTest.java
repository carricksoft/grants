/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.capitalisation;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.CapitalisationImpl;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CapitalisationLengthTest {

    private Capitalisation capitalisation;

    @Before
    public void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    public void lowLengthTest() {
        assertEquals("ab", capitalisation.getCapitalisation("ab"));
    }

    @Test
    public void topLengthTest() {
        assertEquals("Abc", capitalisation.getCapitalisation("abc"));
    }

    @Test
    public void highLengthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Abcd", capitalisation.getCapitalisation("abcd"));
    }

}
