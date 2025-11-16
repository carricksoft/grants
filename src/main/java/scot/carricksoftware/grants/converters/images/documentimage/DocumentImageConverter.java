/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.documentimage;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.DocumentImage;

@SuppressWarnings("unused")
@Component
public interface DocumentImageConverter extends Converter<DocumentImage, DocumentImageCommand> {

    @SuppressWarnings("NullableProblems")
    DocumentImageCommand convert(DocumentImage source);
}
