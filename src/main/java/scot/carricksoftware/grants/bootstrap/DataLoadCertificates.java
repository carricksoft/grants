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
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);

    public void load() {
        logger.debug("DataLoadCertificates::load");
        loadBirthCertificates();
        loadDeathCertificates();
    }

    private void loadBirthCertificates() {
        logger.debug("DataLoadCertificates::LoadBirthCertificates");
    }

    private void loadDeathCertificates() {
        logger.debug("DataLoadCertificates::LoadDeathCertificates");
    }


}
