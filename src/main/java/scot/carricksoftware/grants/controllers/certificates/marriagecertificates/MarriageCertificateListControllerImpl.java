/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;

import static java.lang.Integer.max;

@Controller
public class MarriageCertificateListControllerImpl implements MarriageCertificateListController {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateListControllerImpl.class);
    private final MarriageCertificateService marriageCertificateService;

    private int currentPage = 0;
    private final ControllerHelper controllerHelper;

    public MarriageCertificateListControllerImpl(ControllerHelper controllerHelper,
                                                 MarriageCertificateService marriageCertificateService) {
        this.controllerHelper = controllerHelper;
        this.marriageCertificateService = marriageCertificateService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("MarriageCertificateListControllerImpl::getCensusPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATES, marriageCertificateService.getPagedMarriageCertificates(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.MARRIAGE_CERTIFICATE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("MarriageCertificateListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("MarriageCertificateListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("MarriageCertificateListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("MarriageCertificateListControllerImpl::getLastPage");
        long certificateCount = marriageCertificateService.count();
        currentPage = (int) (certificateCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_DELETE)
    @Override
    public final String marriageCertificateDelete(@PathVariable final String id) {
        logger.debug("MarriageCertificateControllerImpl::censusDelete");
        marriageCertificateService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + CertificateMappingConstants.MARRIAGE_CERTIFICATE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
