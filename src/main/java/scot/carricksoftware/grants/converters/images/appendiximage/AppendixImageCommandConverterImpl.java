/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.appendiximage;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.domains.images.AppendixImage;

@Component
public class AppendixImageCommandConverterImpl implements AppendixImageCommandConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public AppendixImage convert(@NotNull AppendixImageCommand source) {
        AppendixImage target = new AppendixImage();
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
