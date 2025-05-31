/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.places.organisations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

@Controller
public class OrganisationListControllerImpl implements OrganisationListController {


    private static final Logger logger = LogManager.getLogger(OrganisationListControllerImpl.class);

    private int currentPage = 0;

    private final ControllerHelper controllerHelper;
    private final OrganisationService organisationService;

    public OrganisationListControllerImpl(ControllerHelper controllerHelper,
                                          OrganisationService organisationService) {
        this.controllerHelper = controllerHelper;
        this.organisationService = organisationService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getOrganisationPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.getPagedOrganisations(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.ORGANISATION_LIST;
    }

}
