/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.CrudRepository;
import scot.carricksoftware.grants.domains.places.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
