/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Census extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "`census_date`")
    private CensusDate censusDate;

    @OneToMany(mappedBy = "census", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CensusEntry> censusEntries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "`place_id`")
    private Place place;

    @Enumerated(EnumType.STRING)
    @Column(name = "`boundary_type`")
    private CensusBoundaryType boundaryType;

    @Column(name = "`inhabited_rooms`")
    private String inhabitedRooms;

    @Column(name = "`rooms_with_windows`")
    private String roomsWithWindows;

    @Column(name = "`filled_in_by`")
    private String filledInBy;

    @Column(name = "`total_rooms`")
    private String totalRooms;

    public CensusDate getCensusDate() {
        return censusDate;
    }

    public void setCensusDate(CensusDate date) {
        this.censusDate = date;
    }

    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public String toString() {
        return place.toString() + ", " + censusDate.label;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public CensusBoundaryType getBoundaryType() {
        return boundaryType;
    }

    public void setBoundaryType(CensusBoundaryType boundaryType) {
        this.boundaryType = boundaryType;
    }

    public String getInhabitedRooms() {
        return inhabitedRooms;
    }

    public void setInhabitedRooms(String inhabitedRooms) {
        this.inhabitedRooms = inhabitedRooms;
    }

    public String getRoomsWithWindows() {
        return roomsWithWindows;
    }

    public void setRoomsWithWindows(String roomsWithWindows) {
        this.roomsWithWindows = roomsWithWindows;
    }

    public String getFilledInBy() {
        return filledInBy;
    }

    public void setFilledInBy(String filledInBy) {
        this.filledInBy = filledInBy;
    }

    public String getTotalRooms() {
        return totalRooms;
    }

    @SuppressWarnings("unused")
    public void setTotalRooms(String totalRooms) {
        this.totalRooms = totalRooms;
    }
}
