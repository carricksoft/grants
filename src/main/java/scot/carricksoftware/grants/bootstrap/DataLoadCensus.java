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
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusEntryServiceImpl;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import java.time.LocalDate;

@Component
public class DataLoadCensus {

    private static final Logger logger = LogManager.getLogger(DataLoadCensus.class);

    final CensusServiceImpl censusService;
    final PlaceServiceImpl placeService;
    final CensusEntryServiceImpl censusEntryService;
    final PersonServiceImpl personService;

    final Census census = new Census();

    @Autowired
    public DataLoadCensus(CensusServiceImpl censusService,
                          PlaceServiceImpl placeService,
                          CensusEntryServiceImpl censusEntryService,
                          PersonServiceImpl personService) {
        this.censusService = censusService;
        this.placeService = placeService;
        this.censusEntryService = censusEntryService;
        this.personService = personService;
    }

    @Transactional
    public void load() {
        logger.debug("DataLoadCensus::load");
        Place place = buildPlace();
        loadCensus(place);
        loadCensusEntry();
    }


    private Place buildPlace() {
        return placeService.findById(1L);
    }

    private void loadCensus(Place place) {
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        census.setPlace(place);
        census.setDate(date);
        censusService.save(census);
    }

    private void loadCensusEntry() {
       CensusEntry censusEntry = new CensusEntry();
       censusEntry.setPerson(personService.findById(1L));
       censusEntry.setOtherPerson("Archie Grant");
       censusEntryService.save(censusEntry);
    }


}
