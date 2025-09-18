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

    public static final String ORGANISATION_LIST = "organisation/list";
    public static final String ORGANISATION_FORM = "organisation/form";

    public static final String REGION_LIST = "region/list";
    public static final String REGION_FORM = "region/form";

    public static final String PLACE_LIST = "place/list";
    public static final String PLACE_FORM = "place/form";

    public static final String CENSUS_LIST = "census/list";
    public static final String CENSUS_FORM = "census/form";

    public static final String CENSUS_ENTRY_LIST = "censusEntry/list";
    public static final String CENSUS_ENTRY_FORM = "censusEntry/form";

    public static final String SELECTED_CENSUS_LIST = "selectedCensus/list";

    @SuppressWarnings("unused")
    public static final String BIRTH_CERTIFICATE_LIST = "certificates/birthCertificate/list";
    public static final String BIRTH_CERTIFICATE_FORM = "certificates/birthCertificate/form";

    public static final String DEATH_CERTIFICATE_LIST = "certificates/deathCertificate/list";
    public static final String DEATH_CERTIFICATE_FORM = "certificates/deathCertificate/form";

    public static final String MARRIAGE_CERTIFICATE_LIST = "certificates/marriageCertificate/list";
    public static final String MARRIAGE_CERTIFICATE_FORM = "certificates/marriageCertificate/form";

    public static final String DIVORCE_CERTIFICATE_LIST = "certificates/divorceCertificate/list";
    public static final String DIVORCE_CERTIFICATE_FORM = "certificates/divorceCertificate/form";

    public static final String IMAGE_LIST = "images/image/list";
    public static final String IMAGE_FORM = "images/image/form";

    public static final String PERSON_IMAGE_LIST = "images/personImage/list";
    public static final String PERSON_IMAGE_FORM = "images/personImage/form";

    public static final String PLACE_IMAGE_LIST = "images/placeImage/list";
    public static final String PLACE_IMAGE_FORM = "images/placeImage/form";

    public static final String DOCUMENT_TEXT_LIST = "text/documentText/list";
    public static final String DOCUMENT_TEXT_FORM = "text/documentText/form";

    public static final String APPENDIX_TEXT_LIST = "text/appendixText/list";
    public static final String APPENDIX_TEXT_FORM = "text/appendixText/form";

    public static final String PERSON_TEXT_LIST = "text/personText/list";
    public static final String PERSON_TEXT_FORM = "text/personText/form";

    public static final String PLACE_TEXT_LIST = "text/placeText/list";
    public static final String PLACE_TEXT_FORM = "text/placeText/form";


}


