/*
 * Copyright (c)  07 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ButtonConstants {
    private ButtonConstants() {
        // to stop checkstyle complaining
    }

    @SuppressWarnings("unused")
    public static final String DELETE = "Delete";
    @SuppressWarnings("unused")
    public static final String EDIT = "Edit";

    @SuppressWarnings("unused")
    public static final String NEW = "New ";//Note the space at the end
    @SuppressWarnings("unused")
    public static final String HOME = "Home ";
    @SuppressWarnings("unused")
    public static final String REWIND = "<<";
    @SuppressWarnings("unused")
    public static final String BACK = "<";
    @SuppressWarnings("unused")
    public static final String END = ">>";
    @SuppressWarnings("unused")
    public static final String FORWARD = ">";

}
