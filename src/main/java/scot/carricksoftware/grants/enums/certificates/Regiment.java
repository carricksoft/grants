/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.certificates;

public enum Regiment {

    @SuppressWarnings("unused") HLI15("15th Btn. Highland Light Infantry"),
    @SuppressWarnings("unused") CH2("2nd Btn. Cameron Highlanders");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    Regiment(String label) {
        this.label = label;
    }
}
