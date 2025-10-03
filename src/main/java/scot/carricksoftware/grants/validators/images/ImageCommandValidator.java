/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.ImageCommand;

public interface ImageCommandValidator {
    @SuppressWarnings("unused")
    void validate(ImageCommand imageCommand, BindingResult bindingResult);
}
