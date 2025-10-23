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

    public static final String BIRTHDAY_INCORRECT_FORMAT = "Format should be dd/mm";
    public static final String BIRTH_DAY_AND_AGE_CANNOT_COEXIST = "BirthDay and Age cannot coexist.";
    public static final String BIRTH_YEAR_AND_AGE_CANNOT_COEXIST = "Birth Year and Age cannot coexist.";
    public static final String BOUNDARY_TYPE_IS_NULL = "The boundary type cannot be null.";
    public static final String BRIDE_IS_NULL = "The bride cannot be null.";
    public static final String BRIDE_AGE_IS_NULL = "The bride age cannot be null.";
    public static final String BRIDE_RANK_IS_NULL = "The bride rank cannot be null.";
    public static final String BRIDE_CONDITION_IS_NULL = "The bride condition cannot be null.";
    public static final String BRIDE_FATHER_AND_UNTRACKED_FATHER = "One and only one bride father and untracked bride father may be specified.";
    public static final String BRIDE_FATHER_RANK_IS_NULL = "The bride's father's rank cannot be null.";
    public static final String BRIDE_USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE = "One and only one bride residence and untracked bride residence may be specified.";
    public static final String CENSUS_IS_NULL = "The census should be specified";
    public static final String CAUSE_OF_DEATH_IS_NULL = "The cause of death should be specified.";
    public static final String CENSUS_NAME_IS_NOT_NULL = "Both Person and Untracked Person cannot be given";
    public static final String CENSUS_NAME_IS_NULL = "Either Person or Untracked Person must be given";
    public static final String CERTIFICATE_DATE_IS_NULL = "The certificate date cannot be null.";
    public static final String CERTIFICATE_NUMBER_IS_NULL = "The certificate number cannot be null.";
    public static final String CERTIFICATE_SOURCE_IS_NULL = "The certificate source cannot be null.";
    public static final String CERTIFICATE_TYPE_IS_NULL = "The certificate type cannot be null.";
    public static final String COUNTRY_IS_NULL = "Country must exist.";
    public static final String DATE_IN_FUTURE = "Date should not be in the future.";
    public static final String DATE_IS_INVALID = "The certificate date is invalid or of the wrong format.";
    public static final String DATE_IS_NULL = "Date must exist.";
    public static final String DECEASED_IS_NULL = "The deceased cannot be null.";
    public static final String FATHER_AND_UNTRACKED_FATHER = "One and only one father and untracked father must be specified.";
    public static final String FATHER_AND_UNTRACKED_FATHER_OPTIONAL = "One and only one father and untracked father may be specified.";
    public static final String FATHER_USUAL_RESIDENCE_AND_UNTRACKED_FATHER_USUAL_RESIDENCE = "Only one usual residence and untracked usual residence must be specified.";
    public static final String FIELD_NOT_NEGATIVE_INTEGER = "Not a non negative integer.";
    public static final String FIRST_PARTY_IS_NULL = "The first party cannot be null.";
    public static final String FIRST_PARTY_DATE_IS_NULL = "The first party date cannot be null.";
    public static final String FIRST_PARTY_DATE_INVALID_FORMAT = "The format should be dd/MM/yyyy.";
    public static final String GROOM_IS_NULL = "The groom cannot be null.";
    public static final String GROOM_AGE_IS_NULL = "The groom age cannot be null.";
    public static final String GROOM_FATHER_RANK_IS_NULL = "The groom's father's rank cannot be null.";
    public static final String GROOM_RANK_IS_NULL = "The groom rank cannot be null.";
    public static final String GROOM_CONDITION_IS_NULL = "The groom condition cannot be null.";
    public static final String GROOM_FATHER_AND_UNTRACKED_FATHER = "One and only one groom father and untracked groom father may be specified.";
    public static final String GROOM_USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE = "One and only one groom residence and untracked groom residence may be specified.";

    public static final String HEIGHT_IS_NOT_AN_INTEGER = "Height must be an integer.";
    public static final String HEIGHT_IS_NULL = "Height cannot be null.";
    public static final String HEIGHT_OUTSIDE_RANGE = "Height must be between "
            + ApplicationConstants.MINIMUM_IMAGE_HEIGHT
            + " and "
            + ApplicationConstants.MAXIMUM_IMAGE_HEIGHT;
    public static final String IMAGE_DATA_IS_NULL = "The file to upload cannot be null.";
    public static final String IMAGE_IS_NULL = "The image cannot be null.";
    public static final String INFORMANT_QUALIFICATION_IS_NULL = "The informant qualification cannot be null.";
    public static final String INFORMANT_AND_UNTRACKED_INFORMANT = "One and only one informant and untracked informant may be specified.";
    public static final String MOTHER_AND_UNTRACKED_MOTHER = "One and only one mother and untracked mother may be specified.";
    public static final String MOTHER_IS_NULL = "The mother cannot be null.";
    public static final String MOTHER_USUAL_RESIDENCE_AND_UNTRACKED_MOTHER_USUAL_RESIDENCE = "Only one usual residence and untracked usual residence may be specified.";
    public static final String NAME_IS_NULL = "The name cannot be null.";
    public static final String NAME_IS_TOO_LONG = "Name must be no more than " + ApplicationConstants.MAXIMUM_NAME_LENGTH + " characters long.";
    public static final String NAME_IS_TOO_SHORT = "Name must be at least " + ApplicationConstants.MINIMUM_NAME_LENGTH + " characters long.";
    public static final String NEWBORN_IS_NULL = "The New Born cannot be null.";
    public static final String NUMBER_IS_INVALID = "The number must be an integer.";
    public static final String NUMBER_IS_NULL = "The number cannot be null.";
    public static final String NUMBER_IS_NEGATIVE = "The number cannot be negative.";
    public static final String ORDER_IS_NULL = "Order must exist.";
    public static final String ORDER_IS_INVALID = "The order must be an integer." ;
    public static final String ORDER_IS_NEGATIVE = "The order must be non-negative." ;
    public static final String PERSON_IS_NULL = "The person cannot be null.";
    public static final String PLACE_IS_NULL = "Place must exist.";
    public static final String LEVEL_IS_NULL = "Level must exist.";
    public static final String LEVEL_IS_INVALID = "Level must be an integer.";
    public static final String LEVEL_IS_NEGATIVE = "The level must be non-negative.";
    public static final String LEVEL_IS_OUTSIDE_LIMITS = "Level must be between -2 and 5.";
    public static final String REGION_IS_NULL = "Region must exist.";
    public static final String REGISTERED_DATE_IS_NULL = "The registered date cannot be null.";
    public static final String REGISTERED_DATE_INVALID_FORMAT = "The format should be dd/MM/yyyy.";
    public static final String REGISTRATION_AUTHORITY_IS_NULL = "The registration authority cannot be null.";
    public static final String REGISTRATION_VOLUME_IS_NULL = "The volume cannot be null.";
    public static final String SAME_BRIDE_AND_GROOM = "The bride and groom cannot be the same person.";
    public static final String SAME_TWO_PARTIES = "The two parties cannot be the same person.";
    public static final String SECOND_PARTY_IS_NULL = "The second party cannot be null.";
    public static final String SECOND_PARTY_DATE_IS_NULL = "The second party date cannot be null.";
    public static final String SECOND_PARTY_DATE_INVALID_FORMAT = "The format should be dd/MM/yyyy.";
    public static final String SEX_IS_NULL = "Sex cannot be null.";
    public static final String SPOUSE_AND_UNTRACKED_SPOUSE = "One and only one spouse and untracked spouse may be specified.";
    public static final String TOTAL_ROOMS_AND_INHABITED_ROOMS_CANNOT_COEXIST =  "Total Rooms and Inhabited Rooms cannot coexist.";
    public static final String TOTAL_ROOMS_AND_ROOMS_WITH_WINDOWS_CANNOT_COEXIST =  "Total Rooms and Rooms With Windows cannot coexist.";
    public static final String UNSUPPORTED_FILE_TYPE = "The file type is not supported.";
    public static final String USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE = "Only one usual residence and untracked usual residence may be specified.";
    public static final String WHEN_BORN_INCORRECT_FORMAT = "The format should be dd/MM/yyyy hh:mm.";
    public static final String WHEN_BORN_IS_NULL = "When born cannot be null.";
    public static final String WHEN_DIED_IS_INVALID = "The format should be dd/MM/yyyy.";
    public static final String WHEN_MARRIED_IS_NULL = "When married cannot be null.";
    public static final String WHEN_MARRIED_INCORRECT_FORMAT = "The format should be dd/MM/yyyy.";
    public static final String WHEN_DIED_IS_NULL = "When died cannot be null.";
    public static final String WHEN_REGISTERED_DATE_IN_FUTURE = "Date should not be in the future.";
    public static final String WHEN_REGISTERED_DATE_IS_INVALID = "When registered date is invalid.";
    public static final String WHEN_REGISTERED_DATE_IS_NULL = "When registered cannot be null.";
    public static final String WHERE_BORN_AND_UNTRACKED_WHERE_BORN = "One and only one where born and untracked where born must be specified.";
    public static final String WHERE_BORN_IS_NULL = "Where born cannot be null.";
    public static final String WHERE_DIED_AND_UNTRACKED_WHERE_DIED = "One and only one where died and untracked where died must be specified.";
    public static final String WHERE_MARRIED_AND_UNTRACKED_WHERE_MARRIED = "One and only one where married and untracked where married must be specified.";
    public static final String WIDTH_IS_NOT_AN_INTEGER = "Width must be an integer.";
    public static final String WIDTH_IS_NULL = "Width cannot be null.";
    public static final String WIDTH_OUTSIDE_RANGE = "Width must be between "
            + ApplicationConstants.MINIMUM_IMAGE_WIDTH
            + " and "
            + ApplicationConstants.MAXIMUM_IMAGE_WIDTH;
    public static final String WITNESS_AND_UNTRACKED_FIRST_WITNESS = "One and only one first witness and untracked first witness may be specified.";
    public static final String WITNESS_AND_UNTRACKED_SECOND_WITNESS = "One and only one second witness and untracked second witness may be specified.";

}
