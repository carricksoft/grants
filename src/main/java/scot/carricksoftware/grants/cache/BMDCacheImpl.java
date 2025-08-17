/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.List;

public class BMDCacheImpl implements BMDCache {

    private final PersonService personService;

    private List<Person> people = null;

    public BMDCacheImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public List<Person> getPeople() {
        if (people == null) {
            people = personService.findAll();
        }
        return people;
    }

    @Override
    public void invalidatePeople() {
         people = null;
    }
}
