/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.census;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.census.CensusCommand;

@SuppressWarnings("unused")

public interface CensusFormController {

    String saveOrUpdate(@ModelAttribute CensusCommand censusCommand, BindingResult bindingResult, Model model);
}
