/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.appendiximage;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.domains.images.AppendixImage;

@SuppressWarnings("unused")
@Component
public interface AppendixImageConverter extends Converter<AppendixImage, AppendixImageCommand> {

    @SuppressWarnings("NullableProblems")
    AppendixImageCommand convert(AppendixImage source);
}
