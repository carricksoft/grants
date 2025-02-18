/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.places.Country;

import java.util.Optional;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    Country save(Country country);

    long count();

    void deleteById(Long id);

    Optional<Country> findById(Long id);
}
