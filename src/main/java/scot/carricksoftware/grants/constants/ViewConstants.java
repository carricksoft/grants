/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ViewConstants {


    private ViewConstants() {
        // to stop checkstyle complaining
    }


    public static final String PEOPLE_LIST = "person/list";
    public static final String PERSON_FORM = "person/form";

    public static final String COUNTRY_LIST = "country/list";
    public static final String COUNTRY_FORM = "country/form";

    public static final String REGION_LIST = "region/list";
    public static final String REGION_FORM = "region/form";

    public static final String PLACE_LIST = "place/list";
    public static final String PLACE_FORM = "place/form";
}
