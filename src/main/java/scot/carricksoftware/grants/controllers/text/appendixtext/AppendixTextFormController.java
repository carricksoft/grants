/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtext;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;

@SuppressWarnings("unused")

public interface AppendixTextFormController {

    String saveOrUpdate(@ModelAttribute AppendixTextCommand appendixTextCommand, BindingResult bindingResult, Model model);
}
