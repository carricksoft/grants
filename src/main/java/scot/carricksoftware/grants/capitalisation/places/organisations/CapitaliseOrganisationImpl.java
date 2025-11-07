/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.organisations;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;

@Component
public class CapitaliseOrganisationImpl implements CapitaliseOrganisation {

    private final CapitaliseString capitaliseString;

    public CapitaliseOrganisationImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(OrganisationCommand command) {
        command.setName(capitaliseString.capitalise(command.getName()));
    }
}
