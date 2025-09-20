/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;

@SuppressWarnings("unused")
@Component
public interface DocumentTextCommandValidator {

    void validate(DocumentTextCommand documentTextCommand, BindingResult bindingResult);

}

