/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private final PlaceService placeService;
    private final CensusService censusService;

    public DataLoadCensus(PlaceService placeService, CensusService censusService) {
        this.placeService = placeService;
        this.censusService = censusService;
    }

    void load() {
        loadCensus();
        loadCensusEntry();
    }

    @SuppressWarnings("EmptyMethod")
    private void loadCensusEntry() {
        //awaiting census entry service
    }


    void loadCensus() {
        CensusCommand censusCommand = new CensusCommand();
        censusCommand.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        CensusCommand savedCensusCommand = censusService.saveCensusCommand(censusCommand);

// doing an update stops a detached fault
        savedCensusCommand.setPlace(placeService.findById(1L));
        censusService.saveCensusCommand(savedCensusCommand);
    }

}
