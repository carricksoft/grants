/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);

    final CensusServiceImpl censusService;
    final PlaceServiceImpl placeService;

    @Autowired
    public DataLoadCensus(CensusServiceImpl censusService,
                          PlaceServiceImpl placeService) {
        this.censusService = censusService;
        this.placeService = placeService;
    }


    @Transactional
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
