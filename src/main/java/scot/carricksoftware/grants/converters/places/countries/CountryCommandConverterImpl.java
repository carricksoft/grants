/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.countries;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

@Component
public class CountryCommandConverterImpl implements CountryCommandConverter {

    @Override
    public Country convert(@NotNull CountryCommand source) {
        Country target = new Country();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setRegions(source.getRegions());
        return target;
    }


}
