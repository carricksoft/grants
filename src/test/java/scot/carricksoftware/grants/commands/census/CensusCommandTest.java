/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class CensusCommandTest {

    private CensusCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusCommandImpl();
    }


    @Test
    void getCensusEntriesTest() {
        assertTrue(command.getCensusEntries().isEmpty());
    }

    @Test
    void setCensusEntriesTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        command.setCensusEntries(censusEntries);
        assertEquals(censusEntries, command.getCensusEntries());
    }

    @Test
    public void getPlaceTest() {
        assertNull(command.getPlace());
    }

    @Test
    public void setPlaceTest() {
        Place place = GetRandomPlace();
        command.setPlace(place);
        assertEquals(place, command.getPlace());
    }

    @Test
    public void getInhabitedRoomsTest() {
        assertNull(command.getInhabitedRooms());
    }

    @Test
    public void setInhabitedRoomsTest() {
        String string = GetRandomString();
        command.setInhabitedRooms(string);
        assertEquals(string, command.getInhabitedRooms());
    }

    @Test
    public void getRoomsWithWidowsTest() {
        assertNull(command.getRoomsWithWindows());
    }

    @Test
    public void setRoomsWithWidowsTest() {
        String string = GetRandomString();
        command.setRoomsWithWindows(string);
        assertEquals(string, command.getRoomsWithWindows());
    }

    @Test
    public void getFilledInByTest() {
        assertNull(command.getFilledInBy());
    }

    @Test
    public void setFilledInByTest() {
        String filledInBy = GetRandomString();
        command.setFilledInBy(filledInBy);
        assertEquals(filledInBy, command.getFilledInBy());
    }

    @Test
    public void getTotalRoomsTest() {
        assertNull(command.getTotalRooms());
    }

    @Test
    public void setTotalRoomsTest() {
        String totalRooms = GetRandomString();
        command.setTotalRooms(totalRooms);
        assertEquals(totalRooms, command.getTotalRooms());
    }


}