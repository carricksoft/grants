/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class CensusMappingConstants {

    private CensusMappingConstants() {
        // to stop checkstyle complaining
    }


    @SuppressWarnings("unused")
    public static final String CENSUS_LIST = "/censuses";
    @SuppressWarnings("unused")
    public static final String CENSUS_NEXT = "/censuses/next";
    @SuppressWarnings("unused")
    public static final String CENSUS_PREVIOUS = "/censuses/prev";
    @SuppressWarnings("unused")
    public static final String CENSUS_REWIND = "/censuses/rewind";
    @SuppressWarnings("unused")
    public static final String CENSUS_FF = "/censuses/ff";
    @SuppressWarnings("unused")
    public static final String CENSUS_NEW = "/census/new";
    @SuppressWarnings("unused")
    public static final String CENSUS = "/census";
    @SuppressWarnings("unused")
    public static final String CENSUS_SHOW = "/census/{id}/show";
    @SuppressWarnings("unused")
    public static final String CENSUS_DELETE = "/census/{id}/delete";
    @SuppressWarnings("unused")
    public static final String CENSUS_EDIT = "census/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_LIST = "/censusEntries";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_NEXT = "/censusEntries/next";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_PREVIOUS = "/censusEntries/prev";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_REWIND = "/censusEntries/rewind";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_FF = "/censusEntries/ff";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_NEW = "/censusEntry/new";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY = "/censusEntry";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_SHOW = "/censusEntry/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_DELETE = "/censusEntry/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_ENTRY_EDIT = "censusEntry/{id}/edit";


    public static final String CENSUS_SELECTED_ENTRIES_LIST = "/censusSelectedEntries";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_NEXT = "/censusSelectedEntries/next";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_PREVIOUS = "/censusSelectedEntries/prev";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_REWIND = "/censusSelectedEntries/rewind";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_FF = "/censusSelectedEntries/ff";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_NEW = "/censusSelectedEntry/new";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_ENTRY = "/censusSelectedEntry";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_SHOW = "/censusSelectedEntry/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_DELETE = "/censusSelectedEntry/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String CENSUS_SELECTED_ENTRIES_EDIT = "censusSelectedEntry/{id}/edit";

    public static final String CENSUS_SELECTED_ENTRIES_ENTRIES = "/censusSelectedEntry/{id}/entries";
}
