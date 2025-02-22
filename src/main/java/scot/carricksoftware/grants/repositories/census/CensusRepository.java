/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.Optional;

@Repository
public interface CensusRepository extends PagingAndSortingRepository<Census, Long> {

    Census save(Census census);

    long count();

    void deleteById(Long id);

    Optional<Census> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<Census> findAll();

}
