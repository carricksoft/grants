/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.Optional;

@Repository
public interface CensusEntryRepository extends PagingAndSortingRepository<CensusEntry, Long> {

    CensusEntry save(CensusEntry censusEntry);

    long count();

    void deleteById(Long id);

    Optional<CensusEntry> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<Census> findAll();

}
