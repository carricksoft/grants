/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@Component
public class ValidationConstants {
    private ValidationConstants() {
        // to stop checkstyle complaining
    }


    public static final String NAME_IS_TOO_SHORT = "Name must be at least " + ApplicationConstants.MINIMUM_NAME_LENGTH + " characters long.";
    public static final String NAME_IS_TOO_LONG = "Name must be no more than " + ApplicationConstants.MAXIMUM_NAME_LENGTH + " characters long.";

}
