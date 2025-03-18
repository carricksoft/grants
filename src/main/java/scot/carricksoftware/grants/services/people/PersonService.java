/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.people;

import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;

public interface PersonService {

    @SuppressWarnings("unused")
    Person findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    Person save(Person person);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Person> getPagedPersons(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    PersonCommand savePersonCommand(PersonCommand personCommand);

    @SuppressWarnings("unused")
    List<Person> findAll();
}
