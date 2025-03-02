/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class PlaceCommandTest {

    PlaceCommand command;

    @Before
    public void setUp() {
        command = new PlaceCommand();
    }

    @Test
    public void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }

    @Test
    public void getCountryTest() {
        assertNull(command.getCountry());
    }

    @Test
    public void setCountryTest() {
        Country country = GetRandomCountry();
        command.setCountry(country);
        assertEquals(country, command.getCountry());
    }

    @Test
    public void getRegionTest() {
        assertNull(command.getRegion());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }

    @Test
    public void getGetToStringNullTest() {
        assertEquals("", command.toString());
    }

    @Test
    public void getGetToStringNotNullTest() {
        Region region = GetRandomRegion();
        Country country = GetRandomCountry();
        String name = GetRandomString();
        command.setRegion(region);
        command.setCountry(country);
        command.setName(name);
        String requiredResult = name + ", " + region.getName() + ", " + country.getName();
        assertEquals(requiredResult, command.toString());
    }


}