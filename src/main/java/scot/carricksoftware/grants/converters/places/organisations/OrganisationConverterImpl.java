/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.organisations;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.domains.places.Organisation;

@Component
public class OrganisationConverterImpl implements OrganisationConverter {

    @Override
    public OrganisationCommand convert(Organisation source) {
        OrganisationCommand target = new OrganisationCommandImpl();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}
