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
    public static final String PERSON_SHOW = "/person/show/{id}";
    public static final String PERSON_DELETE = "/person/delete/{id}";
    public static final String REDIRECT = "redirect:";


}
