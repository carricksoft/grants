/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;

@SuppressWarnings("unused")

public interface PlaceFormController {

    String saveOrUpdate(@ModelAttribute CountryCommand countryCommand, BindingResult bindingResult);
}
