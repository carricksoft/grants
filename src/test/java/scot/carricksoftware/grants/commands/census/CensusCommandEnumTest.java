/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;

class CensusCommandEnumTest {

    private CensusCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusCommandImpl();
    }

    @Test
    void getBoundaryType() {
        assertNull(command.getBoundaryType());
    }

    @Test
    void setBoundaryTypeTest() {
        CensusBoundaryType boundaryType = GetRandomCensusBoundaryType();
        command.setBoundaryType(boundaryType);
        assertEquals(boundaryType, command.getBoundaryType());
    }

    @Test
    void getDateTest() {
        assertNull(command.getDate());
    }

    @Test
    void setDateTest() {
        CensusDate date = GetRandomCensusDate();
        command.setDate(date);
        assertEquals(date, command.getDate());
    }
}