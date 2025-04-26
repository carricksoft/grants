/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntrySex {

    @SuppressWarnings("unused") MALE("Male"),
    FEMALE ("Female");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntrySex(String label) {
        this.label = label;
    }
}
