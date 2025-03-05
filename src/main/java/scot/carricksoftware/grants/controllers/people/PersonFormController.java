/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;

@SuppressWarnings("unused")

public interface PersonFormController {

    String saveOrUpdate(@ModelAttribute PersonCommandImpl personCommandImpl, BindingResult bindingResult);
}
