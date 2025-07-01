/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class DataLoadOrganisations {

    private static final Logger logger = LogManager.getLogger(DataLoadOrganisations.class);

    private final DataLoadCertificateAuthorities dataLoadCertificateAuthorities;

    private final DataLoadRegistrationAuthorities dataLoadRegistrationAuthorities;

    public DataLoadOrganisations(DataLoadCertificateAuthorities dataLoadCertificateAuthorities, DataLoadRegistrationAuthorities dataLoadRegistrationAuthorities) {
        this.dataLoadCertificateAuthorities = dataLoadCertificateAuthorities;
        this.dataLoadRegistrationAuthorities = dataLoadRegistrationAuthorities;
    }

    public void load() {
        logger.debug("DataLoadOrganisation::load");
        dataLoadCertificateAuthorities.load();
        dataLoadRegistrationAuthorities.load();
    }


}
