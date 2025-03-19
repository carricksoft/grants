/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {


    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    private final DataLoadPlaces dataLoadPlaces;
    private final DataLoadPeople dataLoadPeople;
    private final DataLoadCensus dataLoadCensus;

    public DataLoader(DataLoadPlaces dataLoadPlaces,
                      DataLoadPeople dataLoadPeople,
                      DataLoadCensus dataLoadCensus) {
        this.dataLoadPlaces = dataLoadPlaces;
        this.dataLoadPeople = dataLoadPeople;
        this.dataLoadCensus = dataLoadCensus;
    }


    @Override
    public void run(String... args) {
        logger.debug("DataLoader::run");
        dataLoadPlaces.load();
        dataLoadPeople.load();
        dataLoadCensus.load();
    }

}
