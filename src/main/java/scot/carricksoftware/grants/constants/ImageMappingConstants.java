/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ImageMappingConstants {

    private ImageMappingConstants() {
        // to stop checkstyle complaining
    }

 
    @SuppressWarnings({"unused"})
    public static final String IMAGE_LIST = "/images";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_NEXT = "/images/next";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_PREVIOUS = "/images/prev";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_REWIND = "/images/rewind";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_FF = "/images/ff";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_NEW = "/image/new";
    @SuppressWarnings({"unused"})
    public static final String IMAGE = "/image";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_SHOW = "/image/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_DELETE = "/image/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String IMAGE_EDIT = "image/{id}/edit";
}
