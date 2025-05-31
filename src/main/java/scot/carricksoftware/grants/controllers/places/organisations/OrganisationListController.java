/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.places.organisations;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grants.constants.MappingConstants;

public interface OrganisationListController {
    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_LIST)
    String getListPage(Model model);
}
