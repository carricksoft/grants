/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.places.organisations;

import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

import java.util.List;

public interface OrganisationService {


    void deleteById(Long id);


    List<Organisation> getPagedOrganisations(int pageNumber);

    long count();

    OrganisationCommand saveOrganisationCommand(OrganisationCommand organisationCommand);

    List<Organisation> findAll();

    Organisation findById(Long id);

    Organisation save(Organisation organisation);
}
