/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import scot.carricksoftware.grants.domains.people.Person;

import java.util.Set;

public interface PersonService {

    Set<Person> findAll();

    @SuppressWarnings({"SameReturnValue", "unused"})
    Person findById(Long aLong);

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    Person save(Person person);

    @SuppressWarnings({"EmptyMethod", "unused"})
    void delete(Person object);

    @SuppressWarnings({"EmptyMethod", "unused"})
    void deleteById(Long aLong);
}
