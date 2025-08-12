/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SetYearMarriedTest {

    SetYearMarried setYearMarried;

    @BeforeEach
    void setUp() {
        setYearMarried = new SetYearMarriedImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(setYearMarried);
    }
}