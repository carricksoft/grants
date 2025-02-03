/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.people;

import org.springframework.data.repository.CrudRepository;
import scot.carricksoftware.grants.domains.people.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
