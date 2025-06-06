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
public class DataLoadOrganisations {

    private static final Logger logger = LogManager.getLogger(DataLoadOrganisations.class);

    private final OrganisationService organisationService;

    public DataLoadOrganisations(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    public void load() {
        logger.debug("DataLoadOrganisation::load");
        loadRegistrationAuthority();
        loadCertificateSource();
    }

    private void loadCertificateSource() {
        logger.debug("DataLoadOrganisation::loadCertificateSource");
        OrganisationCommand certificateSourceCommand = new OrganisationCommandImpl();
        certificateSourceCommand.setName("Certificate Source");
        organisationService.saveOrganisationCommand(certificateSourceCommand);
    }

    private void loadRegistrationAuthority() {
        logger.debug("DataLoadOrganisation::loadRegistrationAuthority");
        OrganisationCommand registrationAuthorityCommand = new OrganisationCommandImpl();
        registrationAuthorityCommand.setName("Registration Authority");
        organisationService.saveOrganisationCommand(registrationAuthorityCommand);
    }

}
