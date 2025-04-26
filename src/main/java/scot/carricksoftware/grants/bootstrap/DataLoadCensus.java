/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;
import scot.carricksoftware.grants.enums.censusentry.*;
import scot.carricksoftware.grants.services.census.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

@Component
@Profile("dev")
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);


    private final CensusService censusService;
    private final CensusEntryService censusEntryService;
    private final PlaceService placeService;
    private final PersonService personService;

    public DataLoadCensus(CensusService censusService,
                          CensusEntryService censusEntryService,
                          PlaceService placeService,
                          PersonService personService) {

        this.censusService = censusService;
        this.censusEntryService = censusEntryService;
        this.placeService = placeService;
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadCensus();
        loadCensusEntry();
    }

    private void loadCensus() {
        logger.debug("DataLoadCensus::loadCensus");
        CensusCommand censusCommand = new CensusCommandImpl();
        Place place = placeService.findById(1L);
        censusCommand.setCensusDate(CensusDate.CENSUS_1881);
        censusCommand.setPlace(place);
        censusCommand.setBoundaryType(CensusBoundaryType.ISLAND);
        censusCommand.setRoomsWithWindows("1");
        censusCommand.setInhabitedRooms("2");
        censusService.saveCensusCommand(censusCommand);
    }

    private void loadCensusEntry() {
        logger.debug("DataLoadCensus::loadCensusEntry");
        CensusEntryCommand censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setName("Archie Grant");
        censusEntryCommand.setCensus(censusService.findById(1L));
        censusEntryCommand.setPerson(personService.findById(1L));
        censusEntryCommand.setRelationship(CensusEntryRelationship.COUSIN);
        censusEntryCommand.setCondition(CensusEntryCondition.MARRIED);
        censusEntryCommand.setGaelic(CensusEntryGaelic.GAELIC);
        censusEntryCommand.setWorker(CensusEntryWorker.WORKER);
        censusEntryCommand.setAge("72");
        censusEntryCommand.setWhereBorn("Edinburgh");
        censusEntryCommand.setSex(CensusEntrySex.MALE);
        censusEntryCommand.setBirthDay("25/01");
        censusEntryCommand.setBirthYear("1953");

        censusEntryService.saveCensusEntryCommand(censusEntryCommand);
    }


}
