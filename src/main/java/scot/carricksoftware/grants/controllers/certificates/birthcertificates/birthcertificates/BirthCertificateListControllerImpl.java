/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:09. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates.birthcertificates;

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
import scot.carricksoftware.grants.controllers.census.census.CensusListController;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;

import static java.lang.Integer.max;

@Controller
public class BirthCertificateListControllerImpl implements CensusListController {

    private static final Logger logger = LogManager.getLogger(BirthCertificateListControllerImpl.class);
    private final BirthCertificateService birthCertificateService;


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final CensusService censusService;

    public BirthCertificateListControllerImpl(ControllerHelper controllerHelper,
                                              CensusService censusService, BirthCertificateService birthCertificateService) {
        this.controllerHelper = controllerHelper;
        this.censusService = censusService;
        this.birthCertificateService = birthCertificateService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("BirthCertificateListControllerImpl::getCensusPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.BIRTHCERTIFICATES, birthCertificateService.getPagedBirthCertificates(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.BIRTHCERTIFICATE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("BirthCertificateListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("BirthCertificateListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("BirthCertificateListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("BirthCertificateListControllerImpl::getLastPage");
        long censusCount = censusService.count();
        currentPage = (int) (censusCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_DELETE)
    @Override
    public final String censusDelete(@PathVariable final String id) {
        logger.debug("BirthCertificateControllerImpl::censusDelete");
        censusService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.BIRTHCERTIFICATE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
