/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.places.CountryCommand;

@SuppressWarnings("unused")

public interface CountryFormController {

    String saveOrUpdate(@ModelAttribute CountryCommand countryCommand, BindingResult bindingResult);
}
