/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import scot.carricksoftware.grants.commands.images.ImageCommand;

import java.io.IOException;

@SuppressWarnings("unused")

public interface ImageFormController {

    String saveOrUpdate(@Valid @ModelAttribute ImageCommand imageCommand,
                        @RequestParam MultipartFile file,
                        BindingResult bindingResult, Model model) throws IOException;
}
