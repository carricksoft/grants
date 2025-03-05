/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

@Component
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);

    private final BirthCertificateService birthCertificateService;
    private final PersonService personService;

    public DataLoadCertificates(BirthCertificateService birthCertificateService,
                                PersonService personService) {
        this.birthCertificateService = birthCertificateService;
        this.personService = personService;
    }


    void load() {
        logger.debug("DataLoader::run");
        loadBirthCertificate();
    }


    private void loadBirthCertificate() {
        BirthCertificateCommandImpl birthCertificateCommandImpl = new BirthCertificateCommandImpl();
        birthCertificateCommandImpl.setPerson(personService.findById(1L));
        birthCertificateService.saveBirthCertificateCommand(birthCertificateCommandImpl);
    }


}
