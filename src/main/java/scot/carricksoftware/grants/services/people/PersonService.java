/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;

public interface PersonService {

    @SuppressWarnings("unused")
    Person findById(Long id);

    @SuppressWarnings("unused")
    Person save(Person person);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Person> getPagedPersons(int pageNumber);

    long count();

    PersonCommand savePersonCommand(PersonCommand personCommand);

    List<Person> findAll();
}
