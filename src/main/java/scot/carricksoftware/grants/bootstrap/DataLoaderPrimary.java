/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class DataLoaderPrimary {

    private static final Logger logger = LogManager.getLogger(DataLoaderPrimary.class);

    private final DataLoadPlaces dataLoadPlaces;
    private final DataLoadPeople dataLoadPeople;
    private final DataLoadCensus dataLoadCensus;
    private final DataLoadOrganisations dataLoadOrganisations;

    public DataLoaderPrimary(DataLoadPlaces dataLoadPlaces, DataLoadPeople dataLoadPeople, DataLoadCensus dataLoadCensus, DataLoadOrganisations dataLoadOrganisations) {
        this.dataLoadPlaces = dataLoadPlaces;
        this.dataLoadPeople = dataLoadPeople;
        this.dataLoadCensus = dataLoadCensus;
        this.dataLoadOrganisations = dataLoadOrganisations;
    }

    public void load () {
        logger.debug("DataLoaderPrimary::load");
        dataLoadPeople.load();
        dataLoadOrganisations.load();
        dataLoadPlaces.load();
        dataLoadCensus.load();
    }

}
