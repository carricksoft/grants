/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.selectedcensus;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.List;

@Service
public interface SelectedCensusEntryService {

    @SuppressWarnings("unused")
    CensusEntry findById(Long id);

    void deleteById(Long id);

    List<CensusEntry> getPagedCensusEntries(Census census, int pageNumber);


    long count();


}
