/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class CensusCommandPartTwoTest {

    private CensusCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusCommandImpl();
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

    @Test
    public void getRoomsOccupiedTest() {
        assertNull(command.getRoomsOccupied());
    }

    @Test
    public void setRoomOccupiedTest() {
        String roomsOccupied = GetRandomString();
        command.setRoomsOccupied(roomsOccupied);
        assertEquals(roomsOccupied, command.getRoomsOccupied());
    }

    @Test
    public void getInhabitedHousesTest() {
        assertNull(command.getInhabitedRooms());
    }

    @Test
    public void setInhabitedHousesTest() {
        String inhabitedHouses = GetRandomString();
        command.setInhabitedHouses(inhabitedHouses);
        assertEquals(inhabitedHouses, command.getInhabitedHouses());
    }

    @Test
    public void getUninhabitedHousesTest() {
        assertNull(command.getUninhabitedHouses());
    }

    @Test
    public void setUninhabitedHousesTest() {
        String uninhabitedHouses = GetRandomString();
        command.setUninhabitedHouses(uninhabitedHouses);
        assertEquals(uninhabitedHouses, command.getUninhabitedHouses());
    }

}