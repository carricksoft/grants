/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 23:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.capitalisation;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CapitaliseBirthCertificateCommandLengthTest {

    private CapitaliseString capitaliseString;

    @BeforeEach
    public void setUp() {
        capitaliseString = new CapitaliseStringImpl();
    }

    @Test
    public void lowLengthTest() {
        assertEquals("ab", capitaliseString.capitalise("ab"));
    }

    @Test
    public void topLengthTest() {
        assertEquals("Abc", capitaliseString.capitalise("abc"));
    }

    @Test
    public void highLengthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Abcd", capitaliseString.capitalise("abcd"));
    }

}
