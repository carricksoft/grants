/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.census;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;

@SuppressWarnings("unused")

public interface CensusFormController {

    String saveOrUpdate(@ModelAttribute CensusCommandImpl censusCommandImpl, BindingResult bindingResult);
}
