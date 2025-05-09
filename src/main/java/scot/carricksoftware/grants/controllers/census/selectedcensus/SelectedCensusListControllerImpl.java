/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.selectedcensus;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.census.censusentry.CensusEntryListController;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.selectedcensus.SelectedCensusEntryService;

import static java.lang.Integer.max;

@Controller
public class SelectedCensusListControllerImpl implements CensusEntryListController {

    private static final Logger logger = LogManager.getLogger(SelectedCensusListControllerImpl.class);


    private int currentPage = 0;
    private Census census;

    private final ControllerHelper controllerHelper;
    private final SelectedCensusEntryService selectedCensusEntryService;
    private final CensusService censusService;


    public SelectedCensusListControllerImpl(ControllerHelper controllerHelper,
                                            SelectedCensusEntryService selectedCensusEntryService,
                                            CensusService censusService) {
        this.controllerHelper = controllerHelper;
        this.selectedCensusEntryService = selectedCensusEntryService;
        this.censusService = censusService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("SelectedCensusListControllerImpl::getCensusEntryPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.CENSUS_ENTRIES, selectedCensusEntryService.getPagedCensusEntries(census, currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.SELECTED_CENSUS_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("SelectedCensusListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("SelectedCensusListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("SelectedCensusListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }


    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("SelectedCensusListControllerImpl:getLastPage");
        long censusEntryCount = selectedCensusEntryService.count();
        currentPage = (int) (censusEntryCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_DELETE)
    @Override
    public final String censusEntryDelete(@PathVariable final String id) {
        logger.debug("SelectedCensusListControllerImpl::censusEntryDelete");
        selectedCensusEntryService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + CensusMappingConstants.SELECTED_CENSUS_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.SELECTED_CENSUS_ENTRIES)
    public final String censusEntryList(@Valid @PathVariable final String id, Model model) {
        logger.debug("");
        census = censusService.findById(Long.valueOf(id));
        model.addAttribute(AttributeConstants.CENSUS,  selectedCensusEntryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.CENSUS_ENTRIES, selectedCensusEntryService.getPagedCensusEntries(census, currentPage));
        return ViewConstants.SELECTED_CENSUS_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
