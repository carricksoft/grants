/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;

public interface PersonService {

    @SuppressWarnings("unused")
    Person findById(Long aLong);

    @SuppressWarnings("unused")
    Person save(Person person);

    @SuppressWarnings("unused")
    void delete(Person object);

    @SuppressWarnings("unused")
    List<Person> getPagedPersons(int pageNumber);
}
