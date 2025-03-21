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
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusService;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);


    private final CensusService censusService;
    private final CensusEntryService censusEntryService;

    public DataLoadCensus(CensusService censusService,
                          CensusEntryService censusEntryService) {
        this.censusService = censusService;
        this.censusEntryService = censusEntryService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadCensus();
        loadCensusEntry();
    }

    private void loadCensus() {
        logger.debug("DataLoadCensus::loadCensus");
        CensusCommand censusCommand = new CensusCommandImpl();
        censusCommand.setDate(LocalDate.now());
        censusService.saveCensusCommand(censusCommand);
    }

    private void loadCensusEntry() {
        logger.debug("DataLoadCensus::loadCensusEntry");
        CensusEntryCommand censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setName("Archie Grant");
        censusEntryCommand.setCensus(censusService.findById(1L));
        censusEntryService.saveCensusEntryCommand(censusEntryCommand);
    }


}
