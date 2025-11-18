/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendixImages;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.constants.ImageMappingConstants;

@SuppressWarnings("unused")

public interface AppendixImageFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_NEW)
    String getNewAppendixImage(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_EDIT)
    String appendixImageEdit(@Valid @PathVariable String id, Model model);

    String saveOrUpdate(@ModelAttribute AppendixImageCommand appendixImageCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_SHOW)
    String showById(@PathVariable String id, Model model);
}
