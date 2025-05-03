/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:09. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.censusentry.CensusEntryService;

import static java.lang.Integer.max;

@Controller
public class SelectedSelectedCensusListControllerImpl implements SelectedCensusListController {

    private static final Logger logger = LogManager.getLogger(SelectedSelectedCensusListControllerImpl.class);

    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final CensusService censusService;
    private final CensusEntryService censusEntryService;

    public SelectedSelectedCensusListControllerImpl(ControllerHelper controllerHelper,
                                                    CensusService censusService, CensusEntryService censusEntryService) {
        this.controllerHelper = controllerHelper;
        this.censusService = censusService;
        this.censusEntryService = censusEntryService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getCensusPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }



    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.CENSUSES, censusService.getPagedCensuses(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.CENSUS_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("CensusEntriesListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("CensusEntriesListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("CensusEntriesListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_FF)
    public final String getLastPage(final Model model) {
        logger.debug("CensusEntriesListControllerImpl::getLastPage");
        long censusCount = censusService.count();
        currentPage = (int) (censusCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_DELETE)
    @Override
    public final String censusDelete(@PathVariable final String id) {
        logger.debug("CensusEntriesListControllerImpl::censusDelete");
        censusService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + CensusMappingConstants.SELECTED_CENSUS_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_ENTRIES)
    @Override
    public String censusEntriesEntries(@Valid @PathVariable final String id, Model model) {
        logger.debug("CensusEntriesListControllerImpl::censusEntriesEntries");
        model.addAttribute(AttributeConstants.CENSUS_ENTRIES, censusEntryService.getPagedCensusEntries(currentPage));
        model.addAttribute(AttributeConstants.CENSUS, censusService.findById(Long.valueOf(id)));
        return ViewConstants.SELECTED_CENSUS_LIST;
    }


    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
