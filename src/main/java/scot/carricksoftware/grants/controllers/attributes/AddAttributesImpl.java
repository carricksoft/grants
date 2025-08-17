/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.attributes;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.cache.BMDCache;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

@Component
public class AddAttributesImpl implements AddAttributes {

    private final BMDCache bmdCache;
    private final PlaceService placeService;
    private final OrganisationService organisationService;

    public AddAttributesImpl(BMDCache bmdCache, PlaceService placeService, OrganisationService organisationService) {
        this.bmdCache = bmdCache;
        this.placeService = placeService;
        this.organisationService = organisationService;
    }

    @Override
    public void AddBMDCertificate(Model model) {
        model.addAttribute(AttributeConstants.PEOPLE, bmdCache.getPeople());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
    }

}
