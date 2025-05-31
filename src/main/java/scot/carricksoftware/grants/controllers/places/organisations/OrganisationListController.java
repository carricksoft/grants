/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.places.organisations;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.MappingConstants;

public interface OrganisationListController {
    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_LIST)
    String getListPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_NEXT)
    String getNextPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_PREVIOUS)
    String getPreviousPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_FF)
    String getLastPage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_DELETE)
    String organisationDelete(@PathVariable String id);

    @SuppressWarnings("unused")
    int getPageNumber();
}
