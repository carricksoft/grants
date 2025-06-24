/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class CapitalisePersonTest {


    private CapitalisePerson capitalisePerson;

    @BeforeEach
    void setUp() {
        capitalisePerson = new CapitalisePersonImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(capitalisePerson);
    }
}