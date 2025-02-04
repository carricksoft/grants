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
import scot.carricksoftware.grants.services.people.PersonService;


@Component
public class DataLoader implements CommandLineRunner {

    private final PersonService personService;
    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    public DataLoader(PersonService personService) {
        logger.debug("DataLoader::DataLoader");
        this.personService = personService;
    }

    @Override
    public void run(String... args) {
        logger.debug("DataLoader::run");
        loadPeople();

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
