/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.documentimage;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;


@Component
public class DocumentImageConverterImpl implements DocumentImageConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public DocumentImageCommand convert(DocumentImage source) {
        DocumentImageCommand target = new DocumentImageCommandImpl();
        target.setId(source.getId());
        target.setOrder(source.getOrder());
        target.setCaption(source.getCaption());
        target.setHeight(source.getHeight());
        target.setWidth(source.getWidth());
        target.setImage(source.getImage());
        target.setLevel(source.getLevel());

        return target;
    }
}


