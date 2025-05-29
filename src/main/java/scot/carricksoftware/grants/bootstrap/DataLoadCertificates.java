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
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

@Component
@Profile("dev")
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);

    private final BirthCertificateService birthCertificateService;
    private final DeathCertificateService deathCertificateService;
    private final PersonService personService;
    private final PlaceService placeService;

    public DataLoadCertificates(BirthCertificateService birthCertificateService,
                                DeathCertificateService deathCertificateService,
                                PersonService personService, PlaceService placeService) {
        this.birthCertificateService = birthCertificateService;
        this.deathCertificateService = deathCertificateService;
        this.personService = personService;
        this.placeService = placeService;
    }


    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadBirthCertificates();
        loadDeathCertificates();
    }

    private void loadBirthCertificates() {
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();
        birthCertificateCommand.setNewBorn(personService.findById(1L));
        birthCertificateCommand.setCertificateDate("25/01/1953");
        birthCertificateCommand.setCertificateNumber("999");
        Place place = placeService.findById(1L);

        birthCertificateCommand.setCertificateIssuedAt(place);

        birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);

    }

    private void loadDeathCertificates() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificate.setDeceased(personService.findById(1L));
        deathCertificateService.save(deathCertificate);
    }


}
