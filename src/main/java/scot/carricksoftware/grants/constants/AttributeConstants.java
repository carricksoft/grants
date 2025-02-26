/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class AttributeConstants {

    private AttributeConstants() {
        // to stop checkstyle complaining
    }

    public static final String PEOPLE = "people";
    public static final String PERSON_COMMAND = "personCommand";

    public static final String COUNTRIES = "countries";
    public static final String COUNTRY_COMMAND = "countryCommand";

    public static final String REGIONS = "regions";
    public static final String REGION_COMMAND = "regionCommand";

    public static final String PLACES = "places";
    public static final String PLACE_COMMAND = "placeCommand";

    public static final String CENSUSES = "censuses";
    public static final String CENSUS_COMMAND = "censusCommand";

}
