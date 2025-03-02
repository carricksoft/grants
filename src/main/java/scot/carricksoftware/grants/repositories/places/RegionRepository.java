/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.Optional;

@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    Region save(Region region);

    long count();

    void deleteById(Long id);

    Optional<Region> findById(Long id);

    Iterable<Region> findAll();
}
