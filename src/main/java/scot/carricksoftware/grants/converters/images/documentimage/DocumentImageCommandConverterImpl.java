/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.documentimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.DocumentImage;

@Component
public class DocumentImageCommandConverterImpl implements DocumentImageCommandConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public DocumentImage convert(@NotNull DocumentImageCommand source) {
        DocumentImage target = new DocumentImage();
        target.setId(source.getId());
        target.setImage(source.getImage());
        target.setLevel(source.getLevel());
        target.setOrder(source.getOrder());
        target.setCaption(source.getCaption());
        target.setHeight(source.getHeight());
        target.setWidth(source.getWidth());
        return target;
    }


}
