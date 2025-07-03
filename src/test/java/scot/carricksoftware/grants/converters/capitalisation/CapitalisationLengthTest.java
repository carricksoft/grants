/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.capitalisation;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CapitalisationLengthTest {

    private Capitalisation capitalisation;

    @BeforeEach
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
