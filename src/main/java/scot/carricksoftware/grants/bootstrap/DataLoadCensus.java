/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.services.census.CensusService;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);


    private final CensusService censusService;

    public DataLoadCensus(CensusService censusService) {
        this.censusService = censusService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadCensus();
    }

    private void loadCensus() {
        logger.debug("DataLoadCensus::loadCensus");
        CensusCommand censusCommand = new CensusCommandImpl();
        censusCommand.setDate(LocalDate.now());
        censusService.saveCensusCommand(censusCommand);
    }



}
