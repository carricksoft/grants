/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;


@Component
public class DataLoader implements CommandLineRunner {

    private final PersonService personService;
    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    private final CountryService countryService;
    private final PlaceService placeService;
    private final RegionService regionService;

    public DataLoader(PersonService personService, CountryService countryService, PlaceService placeService, RegionService regionService) {
        this.regionService = regionService;
        this.personService = personService;
        this.countryService = countryService;
        this.placeService = placeService;
    }

    @Override
    public void run(String... args) throws GrantsException {
        logger.debug("DataLoader::run");
        loadPeople();
        loadBulkPeople();
        loadPlaces();

    }

    private void loadBulkPeople() {
        logger.debug("DataLoader::loadBulkPeople");
        for (int i = 0; i < 50; i++) {
            Person person = new Person();
            person.setFirstName("First Name");
            person.setLastName("last" + i);
            personService.save(person);
        }
    }

    private void loadPlaces() throws GrantsException {
        logger.debug("DataLoader::loadPlaces");

        Country scotland = new Country();
        scotland.setName("Scotland");
        countryService.save(scotland);

        Region midlothian = new Region();
        midlothian.setName("Midlothian");
        regionService.save(midlothian);

        Place wilsonAvenue = new Place();
        wilsonAvenue.setName("Wilson Avenue");
        wilsonAvenue.setRegion(midlothian);
        wilsonAvenue.setCountry(scotland);
        placeService.save(wilsonAvenue);
    }


    private void loadPeople() {
        logger.debug("DataLoader::loadPeople");
        Person dad = new Person();
        dad.setFirstName("Andrew");
        dad.setLastName("Grant");
        personService.save(dad);

        Person mum = new Person();
        mum.setFirstName("Dorothy");
        mum.setLastName("Bramall");
        personService.save(mum);
    }


}
