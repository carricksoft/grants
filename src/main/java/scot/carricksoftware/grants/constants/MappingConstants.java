/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class MappingConstants {

    private MappingConstants() {
        // to stop checkstyle complaining
    }

    public static final String PEOPLE_LIST = "/people";
    public static final String PEOPLE_NEXT = "/people/next";


}
