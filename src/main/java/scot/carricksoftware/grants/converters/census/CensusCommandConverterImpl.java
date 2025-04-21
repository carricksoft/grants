/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:18. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

@Component
public class CensusCommandConverterImpl implements CensusCommandConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public Census convert(CensusCommand source) {
        Census result = new Census();
        result.setId(source.getId());

        result.setCensusEntries(source.getCensusEntries());
        result.setPlace(source.getPlace());
        result.setBoundaryType(source.getBoundaryType());
        result.setCensusDate(source.getCensusDate());
        result.setInhabitedRooms(source.getInhabitedRooms());
        result.setRoomsWithWindows(source.getRoomsWithWindows());


        return result;
    }


}
