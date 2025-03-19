/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.domains.places.Region;

public class PlaceCensusCommandTest {

    PlaceCommand command;

    @BeforeEach
    public void setUp() {
        command = new PlaceCommandImpl();
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
    public void getRegionTest() {
        assertNull(command.getName());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }


}