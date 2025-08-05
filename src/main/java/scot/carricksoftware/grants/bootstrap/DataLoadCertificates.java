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

    private final DataLoadBirthCertificates dataLoadBirthCertificates;
    private final DataLoadDeathCertificates dataLoadDeathertificates;

    public DataLoadCertificates(DataLoadBirthCertificates dataLoadBirthCertificates,
                                DataLoadDeathCertificates dataLoadDeathertificates) {
        this.dataLoadBirthCertificates = dataLoadBirthCertificates;
        this.dataLoadDeathertificates = dataLoadDeathertificates;
    }


    public void load() {
        logger.debug("DataLoadCertificates::load");
        dataLoadBirthCertificates.load();
        dataLoadDeathertificates.load();
    }





}
