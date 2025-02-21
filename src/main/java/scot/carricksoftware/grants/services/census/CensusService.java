/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census;

import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;


import java.util.List;

public interface CensusService {

    @SuppressWarnings("unused")
    Census findById(Long id);

    @SuppressWarnings("unused")
    Census save(Census census);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Census> getPagedCensuses(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CensusCommand saveCensusCommand(CensusCommand censusCommand);
}
