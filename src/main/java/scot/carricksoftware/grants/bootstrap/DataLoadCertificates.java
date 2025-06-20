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
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;


@Component
@Profile("dev")
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);
    private final OrganisationService organisationService;
    private final BirthCertificateService birthCertificateService;
    private final PersonService personService;
    private final PlaceService placeService;
    private final DeathCertificateService deathCertificateService;

    public DataLoadCertificates(OrganisationService organisationService,
                                BirthCertificateService birthCertificateService,
                                PersonService personService, PlaceService placeService, DeathCertificateService deathCertificateService) {
        this.organisationService = organisationService;
        this.birthCertificateService = birthCertificateService;
        this.personService = personService;
        this.placeService = placeService;
        this.deathCertificateService = deathCertificateService;
    }

    public void load() {
        logger.debug("DataLoadCertificates::load");
        loadBirthCertificates();
        loadDeathCertificates();
    }

    private void loadBirthCertificates() {
        logger.debug("DataLoadCertificates::LoadBirthCertificates");
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();

        birthCertificateCommand.setCertificateNumber("999");
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setCertificateType(CertificateType.EXTRACT);

        birthCertificateCommand.setRegistrationAuthority(organisationService.findByName("Registration Authority"));
        birthCertificateCommand.setVolume("01");
        birthCertificateCommand.setNumber("02");
        birthCertificateCommand.setCertificateSource(organisationService.findByName("Certificate Source"));

        birthCertificateCommand.setNewBorn(personService.findById(3L));
        birthCertificateCommand.setSex(Sex.MALE);
        birthCertificateCommand.setWhenBorn("25/01/1953 01:01");
        birthCertificateCommand.setUntrackedWhereBorn("Edinburgh");
        birthCertificateCommand.setFather(personService.findById(1L));
        birthCertificateCommand.setUntrackedFather("Untracked Father");

        birthCertificateCommand.setMother(personService.findById(2L));
        birthCertificateCommand.setWhereBorn(placeService.findById(1L));
        birthCertificateCommand.setInformant(personService.findById(1L));
        birthCertificateCommand.setUntrackedInformant("Untracked Informant");
        birthCertificateCommand.setInformantQualification("Qualification");

        birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);
    }

    private void loadDeathCertificates() {
        logger.debug("DataLoadCertificates::LoadDeathCertificates");
        DeathCertificateCommand deathCertificateCommand = new DeathCertificateCommandImpl();

        deathCertificateService.saveDeathCertificateCommand(deathCertificateCommand);
    }


}
