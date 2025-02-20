/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.people.RegionCommand;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class RegionCommandTest {

    RegionCommand command;

    @BeforeEach
    void setUp() {
        command = new RegionCommand();
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
    void getPlacesTest() {
        assertNull(command.getPlaces());
    }

    @Test
    void setPlacesTest() {
        Set<Place> places = new HashSet<>();
        places.add(GetRandomPlace());
        command.setPlaces(places);
        Set<Place> retrievedPlaces = command.getPlaces();
        assertTrue(retrievedPlaces.containsAll(places));
        assertTrue(places.containsAll(retrievedPlaces));
    }

}