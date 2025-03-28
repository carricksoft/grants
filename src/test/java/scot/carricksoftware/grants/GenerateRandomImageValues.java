/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.domains.images.Image;

import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")
@Component
public class GenerateRandomImageValues {

    @SuppressWarnings("unused")
    public static Image GetRandomImage() {
        Image image = new Image();
        image.setId(GetRandomLong());
        return image;
    }

    public static ImageCommand GetRandomImageCommand() {
        ImageCommand imageCommand = new ImageCommandImpl();
        imageCommand.setId(GetRandomLong());
        return imageCommand;
    }



}
