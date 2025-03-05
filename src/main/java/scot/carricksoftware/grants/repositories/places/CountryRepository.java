/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Country;

@SuppressWarnings("unused")
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {


}
