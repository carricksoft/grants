/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {
    private static final Logger logger = LogManager.getLogger(CountryServiceImpl.class);
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Set<Country> findAll() {
        logger.debug("CountryServiceImpl::save");
        Set<Country> countrySet = new HashSet<>();
        countryRepository.findAll().iterator().forEachRemaining(countrySet::add);
        return countrySet;
    }

    @Override
    public Country findById(Long aLong) {
        return null;
    }

    @Override
    public Country save(Country country) {
        logger.debug("CountryImpl::save");
        return countryRepository.save(country);
    }

}
