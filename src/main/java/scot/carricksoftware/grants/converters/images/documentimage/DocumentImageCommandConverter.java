/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.documentimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.DocumentImage;

@Component
public interface DocumentImageCommandConverter extends Converter<DocumentImageCommand, DocumentImage> {

    @Override
    DocumentImage convert(@SuppressWarnings("NullableProblems") @NotNull DocumentImageCommand source);


}
