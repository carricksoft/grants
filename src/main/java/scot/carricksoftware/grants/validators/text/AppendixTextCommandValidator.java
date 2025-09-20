/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;

public interface AppendixTextCommandValidator {
    void validate(AppendixTextCommand appendixTextCommand, BindingResult bindingResult);
}
