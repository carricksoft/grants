/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.certificates;

public enum MaritalStatus {

    @SuppressWarnings("unused") WIDOWER("Widower");

    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    MaritalStatus(String label) {
        this.label = label;
    }
}
