/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentImages;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.constants.ImageMappingConstants;

@SuppressWarnings("unused")

public interface DocumentImageFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_NEW)
    String getNewDocumentImage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_EDIT)
    String documentImageEdit(@Valid @PathVariable String id, Model model);

    String saveOrUpdate(@ModelAttribute DocumentImageCommand documentImageCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_SHOW)
    String showById(@PathVariable String id, Model model);
}
