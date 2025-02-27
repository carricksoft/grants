/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.people;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Person save(Person person);

    long count();

    void deleteById(Long id);

    Optional<Person> findById(Long id);

    List<Person> findAll();
}
