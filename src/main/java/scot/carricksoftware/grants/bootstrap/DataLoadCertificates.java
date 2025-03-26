/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;

@Component
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);

    private final BirthCertificateService birthCertificateService;
    private final DeathCertificateService deathCertificateService;

    public DataLoadCertificates(BirthCertificateService birthCertificateService,
                                DeathCertificateService deathCertificateService) {
        this.birthCertificateService = birthCertificateService;
        this.deathCertificateService = deathCertificateService;
    }


    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadBirthCertificates();
        loadDeathCertificates();
    }


    private void loadBirthCertificates() {
       BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificateService.save(birthCertificate);
    }

    private void loadDeathCertificates() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificateService.save(deathCertificate);
    }




}
