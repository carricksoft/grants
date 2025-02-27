/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.censusentry;

import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.List;

public interface CensusEntryService {

    @SuppressWarnings("unused")
    CensusEntry findById(Long id);

    @SuppressWarnings("unused")
    CensusEntry save(CensusEntry censusEntry);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<CensusEntry> getPagedCensusEntries(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CensusEntryCommand saveCensusEntryCommand(CensusEntryCommand censusEntryCommand);
}
