/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.images;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.ImageCommand;

@SuppressWarnings("unused")

public interface ImageFormController {

    String saveOrUpdate(@ModelAttribute ImageCommand imageCommand, BindingResult bindingResult, Model model);
}
