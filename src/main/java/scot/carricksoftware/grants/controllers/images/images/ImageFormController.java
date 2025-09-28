/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.constants.ImageMappingConstants;

@SuppressWarnings("unused")

public interface ImageFormController {

    @PostMapping(ImageMappingConstants.IMAGE)
    String saveOrUpdate(@Valid @ModelAttribute ImageCommand imageCommand, BindingResult bindingResult, Model model);
}
