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

    public static final String ORGANISATIONS = "organisations";
    public static final String ORGANISATION_COMMAND = "organisationCommand";

    public static final String REGIONS = "regions";
    public static final String REGION_COMMAND = "regionCommand";

    public static final String PLACES = "places";
    public static final String PLACE_COMMAND = "placeCommand";

    public static final String IMAGES = "images";

    public static final String CENSUSES = "censuses";
    public static final String CENSUS_COMMAND = "censusCommand";

    public static final String CENSUS = "census";

    public static final String CENSUS_ENTRIES = "censusEntries";
    public static final String CENSUS_ENTRY_COMMAND = "censusEntryCommand";

    public static final String BIRTH_CERTIFICATES = "birthCertificates";
    public static final String BIRTH_CERTIFICATE_COMMAND = "birthCertificateCommand";

    public static final String DEATH_CERTIFICATES = "deathCertificates";
    public static final String DEATH_CERTIFICATE_COMMAND = "deathCertificateCommand";

    public static final String MARRIAGE_CERTIFICATES = "marriageCertificates";
    public static final String MARRIAGE_CERTIFICATE_COMMAND = "marriageCertificateCommand";

    public static final String DIVORCE_CERTIFICATES = "divorceCertificates";
    public static final String DIVORCE_CERTIFICATE_COMMAND = "divorceCertificateCommand";
}
