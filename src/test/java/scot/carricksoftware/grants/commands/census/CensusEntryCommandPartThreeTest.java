/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class CensusEntryCommandPartThreeTest {

    private CensusEntryCommand entry;

    @BeforeEach
    void setUp() {
        entry = new CensusEntryCommandImpl();
    }

    @Test
    public void getChildrenWhoHaveDiedTest() {
        assertNull(entry.getChildrenWhoHaveDied());
    }

    @Test
    public void setChildrenWhoHaveDiedTest() {
        String string = GetRandomString();
        entry.setChildrenWhoHaveDied(string);
        assertEquals(string, entry.getChildrenWhoHaveDied());
    }

    @Test
    public void getChildrenStillAliveTest() {
        assertNull(entry.getChildrenStillAlive());
    }

    @Test
    public void setChildrenStillAliveTest() {
        String string = GetRandomString();
        entry.setChildrenStillAlive(string);
        assertEquals(string, entry.getChildrenStillAlive());
    }

    @Test
    public void getChildrenBornAliveTest() {
        assertNull(entry.getChildrenBornAlive());
    }

    @Test
    public void setChildrenBornAliveTest() {
        String string = GetRandomString();
        entry.setChildrenBornAlive(string);
        assertEquals(string, entry.getChildrenBornAlive());
    }

    @Test
    public void getYearsCompletedMarriageTest() {
        assertNull(entry.getYearsCompletedMarriage());
    }

    @Test
    public void setYearsCompletedMarriageTest() {
        String string = GetRandomString();
        entry.setYearsCompletedMarriage(string);
        assertEquals(string, entry.getYearsCompletedMarriage());
    }



}