/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Optional;

public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

    Place save(Place place);

    long count();

    void deleteById(Long id);

    Optional<Place> findById(Long id);
}
