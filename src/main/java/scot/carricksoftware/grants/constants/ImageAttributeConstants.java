/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ImageAttributeConstants {

    private ImageAttributeConstants() {
        // to stop checkstyle complaining
    }

    @SuppressWarnings({"unused"})
    public static final String IMAGES = "images";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_COMMAND = "imageCommand";
}
