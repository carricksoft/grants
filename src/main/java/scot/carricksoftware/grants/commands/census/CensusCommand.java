/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;

import java.util.List;

public interface CensusCommand {
    Long getId();

    void setId(Long id);

    CensusDate getCensusDate();

    void setCensusDate(CensusDate date);

    List<CensusEntry> getCensusEntries();

    void setCensusEntries(List<CensusEntry> censusEntries);

    Place getPlace();

    void setPlace(Place place);

    CensusBoundaryType getBoundaryType();

    void setBoundaryType(CensusBoundaryType boundaryType);

    String getInhabitedRooms();

    void setInhabitedRooms(String inhabitedRooms);

    String getRoomsWithWindows();

    void setRoomsWithWindows(String roomsWithWindows);

    String getFilledInBy();

    void setFilledInBy(String filledInBy);

    String getTotalRooms();

    void setTotalRooms(String totalRooms);
}
