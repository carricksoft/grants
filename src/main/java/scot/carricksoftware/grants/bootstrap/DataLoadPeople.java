/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;


@Component
@Profile("dev")
public class DataLoadPeople {

    private static final Logger logger = LogManager.getLogger(DataLoadPeople.class);

    private final PersonService personService;

    public DataLoadPeople(PersonService personService) {
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadDad();
        loadMum();
        loadMe();
    }

    private void loadDad() {
        final Person dad = new Person();
        dad.setFirstName("Andrew");
        dad.setLastName("Grant");
        dad.setCertifiedYearOfBirth("1920");
        dad.setRecordedYearOfBirth("1925");
        personService.save(dad);
    }

    private void loadMum() {
        final Person mum = new Person();
        mum.setFirstName("Dorothy");
        //noinspection SpellCheckingInspection
        mum.setLastName("Bramall");
        mum.setCertifiedYearOfBirth("1910");
        mum.setRecordedYearOfBirth("1915");
        personService.save(mum);
    }

    private void loadMe() {
        final Person mum = new Person();
        mum.setFirstName("Andrew Peter");
        mum.setLastName("Grant");
        mum.setCertifiedYearOfBirth("1953");
        mum.setRecordedYearOfBirth("1953");
        personService.save(mum);
    }


}
