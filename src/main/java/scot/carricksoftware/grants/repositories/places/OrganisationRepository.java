/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.places;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.places.Organisation;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends PagingAndSortingRepository<Organisation, Long> {

    Organisation save(Organisation organisation);

    long count();

    void deleteById(Long id);

    Optional<Organisation> findById(Long id);

    @NotNull Iterable<Organisation> findAll(@NotNull Sort sort);

    Optional<Organisation> findByName(String name);
}
