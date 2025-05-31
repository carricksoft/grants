/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.places.organisations;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.constants.MappingConstants;

public interface OrganisationFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_NEW)
    String getNewOrganisation(Model model);

    String saveOrUpdate(@Valid @ModelAttribute OrganisationCommand organisationCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_SHOW)
    String showById(@PathVariable String id, Model model);
}
