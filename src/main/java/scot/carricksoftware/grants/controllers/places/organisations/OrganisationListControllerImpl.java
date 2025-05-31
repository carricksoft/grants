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
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import static java.lang.Math.max;

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

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("OrganisationListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("OrganisationListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("OrganisationListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("OrganisationListControllerImpl::getLastPage");
        long organisationCount = organisationService.count();
        currentPage = (int) (organisationCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_DELETE)
    @Override
    public final String organisationDelete(@PathVariable final String id) {
        logger.debug("OrganisationListControllerImpl::organisationDelete");
        organisationService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.ORGANISATIONS;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
