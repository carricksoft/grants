/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendixImages;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;

@SuppressWarnings("unused")

public interface AppendixImageFormController {

    String saveOrUpdate(@ModelAttribute AppendixImageCommand appendixImageCommand, BindingResult bindingResult, Model model);
}
