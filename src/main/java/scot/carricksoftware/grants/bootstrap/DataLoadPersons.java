/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

@Component
public class DataLoadPersons {

    private static final Logger logger = LogManager.getLogger(DataLoadPersons.class);

    private final PersonService personService;

    public DataLoadPersons(PersonService personService) {
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadPersons::load");
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
