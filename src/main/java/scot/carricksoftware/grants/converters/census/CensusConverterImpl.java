/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:13. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.domains.census.Census;

@Component
public class CensusConverterImpl implements CensusConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public CensusCommand convert(Census source) {
        CensusCommand result = new CensusCommandImpl();
        result.setId(source.getId());
        result.setCensusEntries(source.getCensusEntries());
        result.setPlace(source.getPlace());
        result.setBoundaryType(source.getBoundaryType());
        result.setCensusDate(source.getCensusDate());
        result.setInhabitedRooms(source.getInhabitedRooms());
        result.setRoomsWithWindows(source.getRoomsWithWindows());
        result.setFilledInBy(source.getFilledInBy());
        result.setTotalRooms(source.getTotalRooms());

        return result;
    }
}
