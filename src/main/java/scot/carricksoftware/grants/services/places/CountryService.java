/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import scot.carricksoftware.grants.domains.places.Country;

import java.util.Set;

public interface CountryService {

    @SuppressWarnings("unused")
    Set<Country> findAll();

    @SuppressWarnings({"SameReturnValue", "unused"})
    Country findById(Long aLong);

    @SuppressWarnings({"UnusedReturnValue", "unused", "SameReturnValue"})
    Country save(Country country);

}
