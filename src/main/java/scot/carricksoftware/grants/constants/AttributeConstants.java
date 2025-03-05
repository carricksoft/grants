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

    @SuppressWarnings("unused")
    public static final String PEOPLE = "people";
    @SuppressWarnings("unused")
    public static final String PERSON_COMMAND = "personCommand";

    @SuppressWarnings("unused")
    public static final String COUNTRIES = "countries";
    @SuppressWarnings("unused")
    public static final String COUNTRY_COMMAND = "countryCommand";

    @SuppressWarnings("unused")
    public static final String REGIONS = "regions";
    @SuppressWarnings("unused")
    public static final String REGION_COMMAND = "regionCommand";

    @SuppressWarnings("unused")
    public static final String PLACES = "places";
    @SuppressWarnings("unused")
    public static final String PLACE_COMMAND = "placeCommand";

    @SuppressWarnings("unused")
    public static final String CENSUSES = "censuses";
    @SuppressWarnings("unused")
    public static final String CENSUS_COMMAND = "censusCommand";

    @SuppressWarnings({"SpellCheckingInspection", "unused"})
    public static final String CENSUSENTRIES = "censusEntries";
    @SuppressWarnings("unused")
    public static final String CENSUSENTRY_COMMAND = "censusEntryCommand";

    @SuppressWarnings({"SpellCheckingInspection", "unused"})
    public static final String BIRTHCERTIFICATES = "birthcertificates";
    @SuppressWarnings({"unused"})
    public static final String BIRTHCERTIFICATE_COMMAND = "birthCertificateCommand";
}
