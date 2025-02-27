/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;

@SuppressWarnings("unused")

public interface CensusEntryFormController {

    String saveOrUpdate(@ModelAttribute CensusEntryCommand censusEntryCommand, BindingResult bindingResult);
}
