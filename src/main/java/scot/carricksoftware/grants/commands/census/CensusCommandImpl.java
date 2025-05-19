/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;

public class CensusCommandImpl implements CensusCommand {

    private Long id;

    private CensusDate censusDate;

    private List<CensusEntry> censusEntries = new ArrayList<>();

    private Place place;

    private CensusBoundaryType boundaryType;

    private String inhabitedRooms;

    private String roomsWithWindows;

    private String filledInBy;

    private String totalRooms;

    private String roomsOccupied;

    private String inhabitedHouses;

    private String uninhabitedHouses;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public CensusDate getCensusDate() {
        return censusDate;
    }

    @Override
    public void setCensusDate(CensusDate censusDate) {
        this.censusDate = censusDate;
    }

    @Override
    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    @Override
    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public Place getPlace() {
        return place;
    }

    @Override
    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public CensusBoundaryType getBoundaryType() {
        return boundaryType;
    }

    @Override
    public void setBoundaryType(CensusBoundaryType boundaryType) {
        this.boundaryType = boundaryType;
    }

    @Override
    public String getInhabitedRooms() {
        return inhabitedRooms;
    }

    @Override
    public void setInhabitedRooms(String inhabitedRooms) {
        this.inhabitedRooms = inhabitedRooms;
    }

    @Override
    public String getRoomsWithWindows() {
        return roomsWithWindows;
    }

    @Override
    public void setRoomsWithWindows(String roomsWithWindows) {
        this.roomsWithWindows = roomsWithWindows;
    }

    @Override
    public String getFilledInBy() {
        return filledInBy;
    }

    @Override
    public void setFilledInBy(String filledInBy) {
        this.filledInBy = filledInBy;
    }

    @Override
    public String getTotalRooms() {
        return totalRooms;
    }

    @Override
    public void setTotalRooms(String totalRooms) {
        this.totalRooms = totalRooms;
    }

    @Override
    public String getRoomsOccupied() {
        return roomsOccupied;
    }

    @Override
    public void setRoomsOccupied(String roomsOccupied) {
        this.roomsOccupied = roomsOccupied;
    }

    @Override
    public String getInhabitedHouses() {
        return inhabitedHouses;
    }

    @Override
    public void setInhabitedHouses(String inhabitedHouses) {
        this.inhabitedHouses = inhabitedHouses;
    }

    @Override
    public String getUninhabitedHouses() {
        return uninhabitedHouses;
    }

    @Override
    public void setUninhabitedHouses(String uninhabitedHouses) {
        this.uninhabitedHouses = uninhabitedHouses;
    }
}
