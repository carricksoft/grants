/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;

@SuppressWarnings("unused")
@Component
public interface PlaceImageCommandValidator {

    void validate(PlaceImageCommand imageCommand, BindingResult bindingResult);
}

