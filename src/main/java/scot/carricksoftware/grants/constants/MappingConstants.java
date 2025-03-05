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
    @SuppressWarnings("unused")
    public static final String PERSON_NEW = "/person/new";
    @SuppressWarnings("unused")
    public static final String PERSON = "/person";
    public static final String PEOPLE = "/people";
    @SuppressWarnings("unused")
    public static final String PERSON_SHOW = "/person/{id}/show";
    public static final String PERSON_DELETE = "/person/{id}/delete";
    @SuppressWarnings("unused")
    public static final String PERSON_EDIT = "/person/{id}/edit";
    public static final String REDIRECT = "redirect:";

    @SuppressWarnings("unused")
    public static final String COUNTRY_LIST = "/countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_NEXT = "/countries/next";
    @SuppressWarnings("unused")
    public static final String COUNTRY_PREVIOUS = "/countries/prev";
    @SuppressWarnings("unused")
    public static final String COUNTRY_REWIND = "/countries/rewind";
    @SuppressWarnings("unused")
    public static final String COUNTRY_FF = "/countries/ff";
    @SuppressWarnings("unused")
    public static final String COUNTRY_NEW = "/country/new";
    @SuppressWarnings("unused")
    public static final String COUNTRY = "/country";
    @SuppressWarnings("unused")
    public static final String COUNTRIES = "/countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_SHOW = "/country/{id}/show";
    @SuppressWarnings("unused")
    public static final String COUNTRY_DELETE = "/country/{id}/delete";
    @SuppressWarnings("unused")
    public static final String COUNTRY_EDIT = "country/{id}/edit";

    @SuppressWarnings("unused")
    public static final String REGION_LIST = "/regions";
    @SuppressWarnings("unused")
    public static final String REGION_NEXT = "/regions/next";
    @SuppressWarnings("unused")
    public static final String REGION_PREVIOUS = "/regions/prev";
    @SuppressWarnings("unused")
    public static final String REGION_REWIND = "/regions/rewind";
    @SuppressWarnings("unused")
    public static final String REGION_FF = "/regions/ff";
    @SuppressWarnings("unused")
    public static final String REGION_NEW = "/region/new";
    @SuppressWarnings("unused")
    public static final String REGION = "/region";
    @SuppressWarnings("unused")
    public static final String REGIONS = "/regions";
    @SuppressWarnings("unused")
    public static final String REGION_SHOW = "/region/{id}/show";
    @SuppressWarnings("unused")
    public static final String REGION_DELETE = "/region/{id}/delete";
    @SuppressWarnings("unused")
    public static final String REGION_EDIT = "region/{id}/edit";

    @SuppressWarnings("unused")
    public static final String PLACE_LIST = "/places";
    @SuppressWarnings("unused")
    public static final String PLACE_NEXT = "/places/next";
    @SuppressWarnings("unused")
    public static final String PLACE_PREVIOUS = "/places/prev";
    @SuppressWarnings("unused")
    public static final String PLACE_REWIND = "/places/rewind";
    @SuppressWarnings("unused")
    public static final String PLACE_FF = "/places/ff";
    @SuppressWarnings("unused")
    public static final String PLACE_NEW = "/place/new";
    @SuppressWarnings("unused")
    public static final String PLACE = "/place";
    @SuppressWarnings("unused")
    public static final String PLACE_SHOW = "/place/{id}/show";
    @SuppressWarnings("unused")
    public static final String PLACE_DELETE = "/place/{id}/delete";
    @SuppressWarnings("unused")
    public static final String PLACE_EDIT = "place/{id}/edit";

    public static final String CENSUS_LIST = "/censuses";
    public static final String CENSUS_NEXT = "/censuses/next";
    public static final String CENSUS_PREVIOUS = "/censuses/prev";
    public static final String CENSUS_REWIND = "/censuses/rewind";
    public static final String CENSUS_FF = "/censuses/ff";
    @SuppressWarnings("unused")
    public static final String CENSUS_NEW = "/census/new";
    @SuppressWarnings("unused")
    public static final String CENSUS = "/census";
    @SuppressWarnings("unused")
    public static final String CENSUS_SHOW = "/census/{id}/show";
    public static final String CENSUS_DELETE = "/census/{id}/delete";
    @SuppressWarnings("unused")
    public static final String CENSUS_EDIT = "census/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_LIST = "/censusEntries";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_NEXT = "/censusEntries/next";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_PREVIOUS = "/censusEntries/prev";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_REWIND = "/censusEntries/rewind";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_FF = "/censusEntries/ff";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_NEW = "/censusEntry/new";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY = "/censusEntry";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_SHOW = "/censusEntry/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_DELETE = "/censusEntry/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String CENSUSENTRY_EDIT = "censusEntry/{id}/edit";
}
