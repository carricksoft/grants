/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);

    private final CensusService censusService;
    private final PlaceService placeService;

    public DataLoadCensus(CensusService censusService, PlaceService placeService) {
        this.censusService = censusService;
        this.placeService = placeService;
    }


    public void load() {
        logger.debug("DataLoadCensus::load");
        Place place = buildPlace();
        loadCensus(place);
    }


    private Place buildPlace() {
        return placeService.findById(1L);
    }


    private void loadCensus(Place place) {
        Census census = new Census();
        LocalDate date = LocalDate.now();
        census.setPlace(place);
        census.setDate(date);
        censusService.save(census);
    }
}
