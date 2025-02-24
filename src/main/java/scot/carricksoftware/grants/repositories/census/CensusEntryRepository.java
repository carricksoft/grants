/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface CensusEntryRepository extends PagingAndSortingRepository<CensusEntry, Long> {

    @SuppressWarnings("unused")
    CensusEntry save(CensusEntry censusEntry);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<CensusEntry> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<CensusEntry> findAll();

}
