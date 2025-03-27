/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;

@Component
public class DataLoadTwoPartyCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadTwoPartyCertificates.class);

    private final MarriageCertificateService marriageCertificateService;
    private final DivorceCertificateService divorceCertificateService;

    public DataLoadTwoPartyCertificates(MarriageCertificateService marriageCertificateService,
                                        DivorceCertificateService divorceCertificateService) {

        this.marriageCertificateService = marriageCertificateService;
        this.divorceCertificateService = divorceCertificateService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadBirthCertificates();
        loadDivorceCertificates();
    }


    private void loadBirthCertificates() {
       MarriageCertificate marriageCertificate = new MarriageCertificate();
       marriageCertificateService.save(marriageCertificate);

    }

    private void loadDivorceCertificates() {
        DivorceCertificate divorceCertificate = new DivorceCertificate();
        divorceCertificateService.save(divorceCertificate);
    }




}
