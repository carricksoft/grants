/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.certificates;

public enum ServiceRank {

    PRIVATE("Private");

    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    ServiceRank(String label) {
        this.label = label;
    }
}
