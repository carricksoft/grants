/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.census;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.List;

@Service
public interface SelectedCensusService {

    @SuppressWarnings("unused")
    Census findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    Census save(Census census);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Census> getPagedCensuses(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CensusCommand saveCensusCommand(CensusCommand censusCommand);

    @SuppressWarnings("unused")
    List<Census> findAll();
}
