/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

import java.util.List;

public interface CountryService {

    @SuppressWarnings("unused")
    Country findById(Long id);

    @SuppressWarnings("unused")
    Country save(Country country);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Country> getPagedCountries(int pageNumber);

    long count();

    @SuppressWarnings("unused")
    CountryCommand saveCountryCommand(CountryCommand countryCommand);

}
