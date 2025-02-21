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
    @SuppressWarnings("unused")
    public static final String PEOPLE_NEXT = "/people/next";
    public static final String PEOPLE_PREVIOUS = "/people/prev";
    public static final String PEOPLE_REWIND = "/people/rewind";
    public static final String PEOPLE_FF = "/people/ff";
    public static final String PERSON_NEW = "/person/new";
    public static final String PERSON = "/person";
    public static final String PEOPLE = "/people";
    public static final String PERSON_SHOW = "/person/{id}/show";
    public static final String PERSON_DELETE = "/person/{id}/delete";
    public static final String PERSON_EDIT = "/person/{id}/edit";
    public static final String REDIRECT = "redirect:";

    public static final String COUNTRY_LIST = "/countries";
    public static final String COUNTRY_NEXT = "/countries/next";
    public static final String COUNTRY_PREVIOUS = "/countries/prev";
    public static final String COUNTRY_REWIND = "/countries/rewind";
    public static final String COUNTRY_FF = "/countries/ff";
    public static final String COUNTRY_NEW = "/country/new";
    public static final String COUNTRY = "/country";
    public static final String COUNTRIES = "/countries";
    public static final String COUNTRY_SHOW = "/country/{id}/show";
    public static final String COUNTRY_DELETE = "/country/{id}/delete";
    public static final String COUNTRY_EDIT = "country/{id}/edit";

    public static final String REGION_LIST = "/regions";
    public static final String REGION_NEXT = "/regions/next";
    public static final String REGION_PREVIOUS = "/regions/prev";
    public static final String REGION_REWIND = "/regions/rewind";
    public static final String REGION_FF = "/regions/ff";
    public static final String REGION_NEW = "/region/new";
    public static final String REGION = "/region";
    public static final String REGIONS = "/regions";
    public static final String REGION_SHOW = "/region/{id}/show";
    public static final String REGION_DELETE = "/region/{id}/delete";
    public static final String REGION_EDIT = "region/{id}/edit";

    public static final String PLACE_LIST = "/places";
    public static final String PLACE_NEXT = "/places/next";
    public static final String PLACE_PREVIOUS = "/places/prev";
    public static final String PLACE_REWIND = "/places/rewind";
    public static final String PLACE_FF = "/places/ff";
    public static final String PLACE_NEW = "/place/new";
    public static final String PLACE = "/place";

    public static final String PLACE_SHOW = "/place/{id}/show";
    public static final String PLACE_DELETE = "/place/{id}/delete";
    public static final String PLACE_EDIT = "place/{id}/edit";
}
