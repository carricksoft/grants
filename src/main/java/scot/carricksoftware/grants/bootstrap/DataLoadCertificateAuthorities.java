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
public class DataLoadCertificateAuthorities {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificateAuthorities.class);

    private final OrganisationService organisationService;

    public DataLoadCertificateAuthorities(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    public void load() {
        logger.debug("DataLoadCertificateAuthorities::load");
        loadCertificateSource();
    }

    private void loadCertificateSource() {
        logger.debug("DataLoadCertificateAuthorities::loadCertificateSource");
        OrganisationCommand certificateSourceCommand = new OrganisationCommandImpl();
        certificateSourceCommand.setName("General Register Office For Scotland");
        organisationService.saveOrganisationCommand(certificateSourceCommand);
    }


}
