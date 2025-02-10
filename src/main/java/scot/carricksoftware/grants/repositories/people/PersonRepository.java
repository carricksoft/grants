/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.people;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.people.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Person save(Person person);
    long count();
    void deleteById(Long id);
}
