/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@SuppressWarnings("ALL")
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

    public static final String CENSUS_LIST = "census/list";
    public static final String CENSUS_FORM = "census/form";

    public static final String CENSUSENTRY_LIST = "censusentry/list";
    public static final String CENSUSENTRY_FORM = "censusentry/form";

    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_LIST = "certificates/birthcertificate/list";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_FORM = "certificates/birthcertificate/form";
}
