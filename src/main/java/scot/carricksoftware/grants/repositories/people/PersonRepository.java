/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.people;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.people.Person;

@SuppressWarnings("unused")
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {


}
