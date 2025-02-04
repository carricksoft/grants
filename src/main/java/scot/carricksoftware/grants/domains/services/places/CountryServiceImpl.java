/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.services.places;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Country;

import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public Set<Country> findAll() {
        return Set.of();
    }

    @Override
    public Country findById(Long aLong) {
        return null;
    }

    @Override
    public Country save(Country country) {
        return null;
    }

}
