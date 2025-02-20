/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.countries;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

@Component
public class CountryConverterImpl implements Converter<Country, CountryCommand> {

    @Override
    public CountryCommand convert(Country source) {
        CountryCommand target = new CountryCommand();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPlaces(source.getPlaces());
        return target;
    }
}
