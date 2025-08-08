/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryCondition {

    BACHELOR("Bachelor"),
    MARRIED("Married"),
    SINGLE("Single"),
    SPINSTER ("Spinster"),
    WIDOW("Widow"),
    WIDOWED("Widowed"),
    WIDOWER("Widower");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryCondition(String label) {
        this.label = label;
    }
}
