/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.appendiximage;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;

@Component
public class AppendixImageConverterImpl implements AppendixImageConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public AppendixImageCommand convert(AppendixImage source) {
        AppendixImageCommand target = new AppendixImageCommandImpl();
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
