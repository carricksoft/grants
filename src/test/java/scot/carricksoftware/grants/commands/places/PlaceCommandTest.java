/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class PlaceCommandTest {

    PlaceCommand command;

    @BeforeEach
    void setUp() {
        command = new PlaceCommand();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }

    @Test
    void getCountryTest() {
        assertNull(command.getCountry());
    }

    @Test
    void setCountryTest() {
        Country country = GetRandomCountry();
        command.setCountry(country);
        assertEquals(country, command.getCountry());
    }

    @Test
    void getRegionTest() {
        assertNull(command.getRegion());
    }

    @Test
    void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }


}