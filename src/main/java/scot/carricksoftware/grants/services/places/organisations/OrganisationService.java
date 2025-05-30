/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.organisations;

import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

import java.util.List;

public interface OrganisationService {


    @SuppressWarnings("unused")
    OrganisationCommand saveOrganisationCommand(OrganisationCommand organisationCommand);

    void deleteById(Long id);

    List<Organisation> getPagedOrganisations(int pageNumber);

    long count();


    @SuppressWarnings("unused")
    List<Organisation> findAll();

    Organisation findById(Long id);

    Organisation save(Organisation organisation);
}
