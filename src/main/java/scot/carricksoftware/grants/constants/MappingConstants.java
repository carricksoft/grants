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

    @SuppressWarnings("unused")
    public static final String PEOPLE_LIST = "/people";
    @SuppressWarnings("unused")
    public static final String PEOPLE_NEXT = "/people/next";
    @SuppressWarnings("unused")
    public static final String PEOPLE_PREVIOUS = "/people/prev";
    @SuppressWarnings("unused")
    public static final String PEOPLE_REWIND = "/people/rewind";
    @SuppressWarnings("unused")
    public static final String PEOPLE_FF = "/people/ff";
    @SuppressWarnings("unused")
    public static final String PERSON_NEW = "/person/new";
    @SuppressWarnings("unused")
    public static final String PERSON = "/person";
    @SuppressWarnings("unused")
    public static final String PEOPLE = "/people";
    @SuppressWarnings("unused")
    public static final String PERSON_SHOW = "/person/{id}/show";
    @SuppressWarnings("unused")
    public static final String PERSON_DELETE = "/person/{id}/delete";
    @SuppressWarnings("unused")
    public static final String PERSON_EDIT = "/person/{id}/edit";
    public static final String REDIRECT = "redirect:";

    public static final String COUNTRY_LIST = "/countries";
    public static final String COUNTRY_NEXT = "/countries/next";
    public static final String COUNTRY_PREVIOUS = "/countries/prev";
    public static final String COUNTRY_REWIND = "/countries/rewind";
    public static final String COUNTRY_FF = "/countries/ff";
    @SuppressWarnings("unused")
    public static final String COUNTRY_NEW = "/country/new";
    @SuppressWarnings("unused")
    public static final String COUNTRY = "/country";
    public static final String COUNTRIES = "/countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_SHOW = "/country/{id}/show";
    public static final String COUNTRY_DELETE = "/country/{id}/delete";
    @SuppressWarnings("unused")
    public static final String COUNTRY_EDIT = "country/{id}/edit";

    public static final String ORGANISATION_LIST = "/organisations";
    public static final String ORGANISATION_NEXT = "/organisations/next";
    public static final String ORGANISATION_PREVIOUS = "/organisations/prev";
    public static final String ORGANISATION_REWIND = "/organisations/rewind";
    public static final String ORGANISATION_FF = "/organisations/ff";
    @SuppressWarnings("unused")
    public static final String ORGANISATION_NEW = "/organisation/new";
    @SuppressWarnings("unused")
    public static final String ORGANISATION = "/organisation";
    public static final String ORGANISATIONS = "/organisations";
    @SuppressWarnings("unused")
    public static final String ORGANISATION_SHOW = "/organisation/{id}/show";
    public static final String ORGANISATION_DELETE = "/organisation/{id}/delete";
    @SuppressWarnings("unused")
    public static final String ORGANISATION_EDIT = "organisation/{id}/edit";

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


}
