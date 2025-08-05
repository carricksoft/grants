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
    private final DataLoadDeathCertificates dataLoadDeathCertificates;
    private final DataLoadMarriageCertificates dataLoadMarriageCertificates;

    public DataLoadCertificates(DataLoadBirthCertificates dataLoadBirthCertificates,
                                DataLoadDeathCertificates dataLoadDeathCertificates,
                                DataLoadMarriageCertificates dataLoadMarriageCertificates) {
        this.dataLoadBirthCertificates = dataLoadBirthCertificates;
        this.dataLoadDeathCertificates = dataLoadDeathCertificates;
        this.dataLoadMarriageCertificates = dataLoadMarriageCertificates;
    }


    public void load() {
        logger.debug("DataLoadCertificates::load");
        dataLoadBirthCertificates.load();
        dataLoadDeathCertificates.load();
        dataLoadMarriageCertificates.load();
    }





}
