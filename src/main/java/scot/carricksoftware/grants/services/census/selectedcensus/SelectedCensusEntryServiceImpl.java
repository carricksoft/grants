/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.selectedcensus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import java.util.List;

@Service
public class SelectedCensusEntryServiceImpl implements SelectedCensusEntryService {
    private static final Logger logger = LogManager.getLogger(SelectedCensusEntryServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final CensusEntryRepository censusEntryRepository;

    public SelectedCensusEntryServiceImpl(CensusEntryRepository censusEntryRepository) {
        this.censusEntryRepository = censusEntryRepository;
    }

    @Override
    public List<CensusEntry> getPagedCensusEntries(Census census, int pageNumber) {
        logger.debug("SelectedCensusEntryServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<CensusEntry> pagedResult = censusEntryRepository.findAllByCensus(census, paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("SelectedCensusEntryServiceImpl::count");
        return censusEntryRepository.count();
    }


}
