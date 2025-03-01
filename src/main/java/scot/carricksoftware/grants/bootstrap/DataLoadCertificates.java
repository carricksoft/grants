/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.BirthCertificateServiceImpl;
import scot.carricksoftware.grants.services.people.PersonService;

@Component
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);
    private final PersonService personService;

    private BirthCertificateService birthCertificateService;

private final BirthCertificateRepository birthCertificateRepository;
private final BirthCertificateConverterImpl birthCertificateConverter;
private final BirthCertificateCommandConverterImpl birthCertificateCommandConverter;

    public DataLoadCertificates(BirthCertificateRepository birthCertificateRepository,
                                BirthCertificateConverterImpl birthCertificateConverter,
                                BirthCertificateCommandConverterImpl birthCertificateCommandConverter, PersonService personService) {
        this.birthCertificateRepository = birthCertificateRepository;
        this.birthCertificateConverter = birthCertificateConverter;
        this.birthCertificateCommandConverter = birthCertificateCommandConverter;
        this.personService = personService;
    }


    void load() {
        logger.debug("DataLoader::run");
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepository,
                birthCertificateConverter,
                birthCertificateCommandConverter);
        loadBirthCertificate();
    }


    private void loadBirthCertificate() {
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommand();
        Person person = personService.findById(1L);
        birthCertificateCommand.setPerson(person);

        birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);
    }



}
