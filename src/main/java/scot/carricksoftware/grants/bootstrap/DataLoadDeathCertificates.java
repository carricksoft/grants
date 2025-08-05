/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;


@Component
@Profile("dev")
public class DataLoadDeathCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadDeathCertificates.class);
    private final PersonService personService;
    private final DeathCertificateService deathCertificateService;

    public DataLoadDeathCertificates(PersonService personService,
                                     DeathCertificateService deathCertificateService) {
        this.personService = personService;
        this.deathCertificateService = deathCertificateService;
    }

    public void load() {
        logger.debug("DataLoadDeathCertificates::load");
        loadDeathCertificates();
    }


    private void loadDeathCertificates() {
        logger.debug("DataLoadCertificates::LoadDeathCertificates");
        DeathCertificateCommand deathCertificateCommand = new DeathCertificateCommandImpl();
        deathCertificateCommand.setDeceased(personService.findById(1L));
        deathCertificateCommand.setFather(personService.findById(2L));

        deathCertificateService.saveDeathCertificateCommand(deathCertificateCommand);
    }


}
