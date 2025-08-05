/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;


@Component
@Profile("dev")
public class DataLoadBirthCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadBirthCertificates.class);
    private final BirthCertificateService birthCertificateService;
    private final PersonService personService;

    public DataLoadBirthCertificates(BirthCertificateService birthCertificateService,
                                     PersonService personService) {
        this.birthCertificateService = birthCertificateService;
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadBirthCertificates::load");
        loadBirthCertificates();
    }

    private void loadBirthCertificates() {
        logger.debug("DataLoadBirthCertificates::LoadBirthCertificates");
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();

        birthCertificateCommand.setFather(personService.findById(1L));
        birthCertificateCommand.setMother(personService.findById(2L));
        birthCertificateCommand.setNewBorn(personService.findById(3L));

        birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);
    }

}
