/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.people;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.HashSet;
import java.util.Set;


import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class PersonCommandTest {

    PersonCommand command;

    @Before
    public void setUp() {
        command = new PersonCommand();
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
    public void getFirstNameTest() {
        assertNull(command.getFirstName());
    }

    @Test
    public void setFirstNameTest() {
        String name = GetRandomString();
        command.setFirstName(name);
        assertEquals(name, command.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertNull(command.getLastName());
    }

    @Test
    public void setLastNameTest() {
        String name = GetRandomString();
        command.setLastName(name);
        assertEquals(name, command.getLastName());
    }

    @Test
    public void getPlacesTest() {
        assertNull(command.getPlaces());
    }

    @Test
    public void setPlacesTest() {
        Set<Place> places = new HashSet<>();
        places.add(GetRandomPlace());
        command.setPlaces(places);
        Set<Place> retrievedPlaces = command.getPlaces();
        assertTrue(retrievedPlaces.containsAll(places));
        assertTrue(places.containsAll(retrievedPlaces));
    }

}