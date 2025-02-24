/*
 * Copyright (c)  07 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
@Component
public class ApplicationConstants {
    private ApplicationConstants() {
        // to stop checkstyle complaining
    }

    public static final int DEFAULT_PAGE_SIZE = 15;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

}
