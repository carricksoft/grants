/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;


@Component
@Profile("dev")
public class DataLoadRegistrationAuthorities {

    private static final Logger logger = LogManager.getLogger(DataLoadRegistrationAuthorities.class);

    private final OrganisationService organisationService;

    public DataLoadRegistrationAuthorities(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    public void load() {
        logger.debug("DataLoadRegistrationAuthorities::load");
        loadRegistrationAuthority();
    }


    private void loadRegistrationAuthority() {
        logger.debug("DataLoadRegistrationAuthorities::loadRegistrationAuthority");
        OrganisationCommand registrationAuthorityCommand = new OrganisationCommandImpl();
        registrationAuthorityCommand.setName("Registration Authority");
        organisationService.saveOrganisationCommand(registrationAuthorityCommand);
    }

}
