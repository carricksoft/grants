/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);

    private final PlaceService placeService;
    private final CensusService censusService;
    private final PersonService personService;
    private final CensusEntryService censusEntryService;

    public DataLoadCensus(PlaceService placeService, CensusService censusService, PersonService personService, CensusEntryService censusEntryService) {
        this.placeService = placeService;
        this.censusService = censusService;
        this.personService = personService;
        this.censusEntryService = censusEntryService;
    }

    void load() {
        logger.debug("DataLoader::run");
        loadCensus();
        loadCensusEntry();
    }


    private void loadCensusEntry() {
        CensusEntryCommandImpl censusEntryCommandImpl = new CensusEntryCommandImpl();
        Census census = censusService.findById(1L);
        Person person = personService.findById(1L);
        censusEntryCommandImpl.setOtherPerson("Dad");
        censusEntryCommandImpl.setPerson(person);
        censusEntryCommandImpl.setCensus(census);
        censusEntryService.saveCensusEntryCommand(censusEntryCommandImpl);
    }


    void loadCensus() {
        CensusCommandImpl censusCommandImpl = new CensusCommandImpl();
        censusCommandImpl.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        censusCommandImpl.setPlace(placeService.findById(1L));
        censusService.saveCensusCommand(censusCommandImpl);
    }

}
