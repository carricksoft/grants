/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;

public interface DocumentImageCommandValidator {

    @SuppressWarnings("unused")
    void validate(DocumentImageCommand documentImageCommand, BindingResult bindingResult);
}
