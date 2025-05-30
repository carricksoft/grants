/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

@Repository
public interface OrganisationRepository extends PagingAndSortingRepository<Organisation, Long> {

    OrganisationCommand saveOrganisationCommand(OrganisationCommand organisationCommand);

    Iterable<Organisation> findAll();

    void deleteById(Long id);

    long count();

    Organisation save(Organisation organisation);
}
