/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentImages;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;

@SuppressWarnings("unused")

public interface DocumentImageFormController {

    String saveOrUpdate(@ModelAttribute DocumentImageCommand documentImageCommand, BindingResult bindingResult, Model model);
}
