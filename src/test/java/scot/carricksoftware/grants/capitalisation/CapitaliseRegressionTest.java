/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitaliseRegressionTest {

    private CapitaliseString capitaliseString;

    @BeforeEach
    void setUp() {
        capitaliseString = new CapitaliseStringImpl();
    }

    @Test
    void certificateNumberTest() {
        String certificateNumber = "12345CE";
        assertEquals(certificateNumber,capitaliseString.capitalise(certificateNumber));
    }
}