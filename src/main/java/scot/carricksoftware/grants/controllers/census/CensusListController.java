/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.census;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.MappingConstants;

@SuppressWarnings("unused")
@Controller
public interface CensusListController {

    @SuppressWarnings("unused")
    String getListPage(final Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_NEXT)
    String getNextPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_PREVIOUS)
    String getPreviousPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_FF)
    String getLastPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_DELETE)
    String censusDelete(@PathVariable String id);

}
