/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@Component
public class ValidationConstants {
    private ValidationConstants() {
        // to stop checkstyle complaining
    }


    public static final String NAME_IS_TOO_SHORT = "Name must be at least " + ApplicationConstants.MINIMUM_NAME_LENGTH + " characters long.";
    public static final String NAME_IS_TOO_LONG = "Name must be no more than " + ApplicationConstants.MAXIMUM_NAME_LENGTH + " characters long.";
    public static final String DATE_IS_NULL = "Date must exist.";
    public static final String DATE_IN_FUTURE = "Date should not be in the future.";
    public static final String CENSUS_IS_NULL = "The census should be specified";
    public static final String CENSUS_NAME_IS_NULL = "Either Person or Untracked Person must be given";
    public static final String CENSUS_NAME_IS_NOT_NULL = "Both Person and Untracked Person cannot be given";

    public static final String PERSON_IS_NULL = "The person cannot be null.";
    public static final String NEWBORN_IS_NULL = "The New Born cannot be null.";
    public static final String CERTIFICATE_NUMBER_IS_NULL = "The certificate number cannot be null.";
    public static final String SOURCE_IS_NULL = "The certificate source cannot be null.";
    public static final String REGISTRATION_AUTHORITY_IS_NULL = "The registration authority cannot be null.";
    public static final String CERTIFICATE_DATE_IS_NULL = "The certificate date cannot be null.";
    public static final String CERTIFICATE_TYPE_IS_NULL = "The certificate type cannot be null.";
    public static final String DATE_IS_INVALID = "The certificate date is invalid or of the wrong format.";
    public static final String NUMBER_IS_NULL = "The number cannot be null.";
    public static final String NUMBER_IS_INVALID = "The number must be a non negative integer.";
    public static final String REGISTRATION_VOLUME_IS_NULL = "The volume cannot be null.";

    public static final String PLACE_IS_NULL = "The place cannot be null.";
    public static final String COUNTRY_IS_NULL = "The country cannot be null.";
    public static final String REGION_IS_NULL = "The region cannot be null.";

    public static final String BRIDE_IS_NULL = "The bride cannot be null.";
    public static final String GROOM_IS_NULL = "The groom cannot be null.";
    public static final String SAME_BRIDE_AND_GROOM = "The bride and groom cannot be the same person.";

    public static final String FIRST_PARTY_IS_NULL = "The first party cannot be null.";
    public static final String SECOND_PARTY_IS_NULL = "The second party cannot be null.";
    public static final String SAME_TWO_PARTIES = "The two parties cannot be the same person.";

    public static final String BOUNDARY_TYPE_IS_NULL = "The boundary type cannot be null.";

    public static final String FIELD_NOT_NEGATIVE_INTEGER = "Not a non negative integer.";

    public static final String BIRTHDAY_INCORRECT_FORMAT = "Format should be dd/mm";
    public static final String BIRTH_YEAR_AND_AGE_CANNOT_COEXIST = "Birth Year and Age cannot coexist.";
    public static final String BIRTH_DAY_AND_AGE_CANNOT_COEXIST = "BirthDay and Age cannot coexist.";
    public static final String TOTAL_ROOMS_AND_INHABITED_ROOMS_CANNOT_COEXIST =  "Total Rooms and Inhabited Rooms cannot coexist.";
    public static final String TOTAL_ROOMS_AND_ROOMS_WITH_WINDOWS_CANNOT_COEXIST =  "Total Rooms and Rooms With Windows cannot coexist.";
}
