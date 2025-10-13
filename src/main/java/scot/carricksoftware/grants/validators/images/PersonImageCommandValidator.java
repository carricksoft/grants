/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;

public interface PersonImageCommandValidator {

    @SuppressWarnings("unused")
    void validate(PersonImageCommand imageCommand, BindingResult bindingResult);
}
