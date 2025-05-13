/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.census;

public enum CensusDate {

    CENSUS_1881("03/04/1881"),
    CENSUS_1901("31/03/1901"),
    CENSUS_1911("02/04/1911"),
    CENSUS_1939("02/09/1939");


    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusDate(String label) {
        this.label = label;
    }
}
