/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:11. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.appendixtext;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.domains.text.AppendixText;

@Component
public interface AppendixTextCommandConverter extends Converter<AppendixTextCommand, AppendixText> {

    @Override
    AppendixText convert(@SuppressWarnings("NullableProblems") @NotNull AppendixTextCommand source);


}
