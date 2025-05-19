/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class CensusConverterTest {

    private CensusConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Census source = new Census();
        CensusDate censusDate = GetRandomCensusDate();
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        Place place = GetRandomPlace();
        CensusBoundaryType boundaryType = GetRandomCensusBoundaryType();
        String roomsWithWindows = GetRandomString();
        String inhabitedRooms = GetRandomString();
        String filledInBy = GetRandomString();
        String totalRooms = GetRandomString();
        String roomsOccupied = GetRandomString();
        String inhabitedHouses = GetRandomString();
        String uninhabitedHouses = GetRandomString();


        source.setId(id);
        source.setCensusEntries(censusEntries);
        source.setPlace(place);
        source.setBoundaryType(boundaryType);
        source.setCensusDate(censusDate);
        source.setInhabitedRooms(inhabitedRooms);
        source.setRoomsWithWindows(roomsWithWindows);
        source.setFilledInBy(filledInBy);
        source.setTotalRooms(totalRooms);
        source.setRoomsOccupied(roomsOccupied);
        source.setInhabitedHouses(inhabitedHouses);
        source.setUninhabitedHouses(uninhabitedHouses);

        CensusCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(censusEntries, target.getCensusEntries());
        assertEquals(place, target.getPlace());
        assertEquals(boundaryType, target.getBoundaryType());
        assertEquals(censusDate, target.getCensusDate());
        assertEquals(roomsWithWindows, target.getRoomsWithWindows());
        assertEquals(inhabitedRooms, target.getInhabitedRooms());
        assertEquals(filledInBy, target.getFilledInBy());
        assertEquals(totalRooms, target.getTotalRooms());
        assertEquals(roomsOccupied, target.getRoomsOccupied());
        assertEquals(inhabitedHouses, target.getInhabitedHouses());
        assertEquals(uninhabitedHouses, target.getUninhabitedHouses());
    }
}