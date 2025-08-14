/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers;

import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

public class AddAttributeImpl implements AddAttribute {

    private final PersonService personService;
    private final PlaceService placeService;
    private final OrganisationService organisationService;

    public AddAttributeImpl(PersonService personService, PlaceService placeService, OrganisationService organisationService) {
        this.personService = personService;
        this.placeService = placeService;
        this.organisationService = organisationService;
    }

    @Override
    public void AddDeathCertificate(Model model) {
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, new DeathCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
    }
}
