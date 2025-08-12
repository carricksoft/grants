/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;


@Component
@Profile("dev")
public class DataLoadMarriageCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadMarriageCertificates.class);
    private final PersonService personService;
    private final MarriageCertificateService marriageCertificateService;

    public DataLoadMarriageCertificates(PersonService personService,
                                        MarriageCertificateService marriageCertificateService) {
        this.personService = personService;
        this.marriageCertificateService = marriageCertificateService;
    }

    public void load() {
        logger.debug("DataLoadDeathCertificates::load");
        loadDeathCertificates();
    }


    private void loadDeathCertificates() {
        logger.debug("DataLoadCertificates::LoadMarriageCertificates");
        MarriageCertificateCommand marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateCommand.setGroom(personService.findById(1L));
        marriageCertificateCommand.setBride(personService.findById(2L));
        marriageCertificateCommand.setWhenMarried("25/01/1953");

        marriageCertificateService.saveMarriageCertificateCommand(marriageCertificateCommand);
    }


}
