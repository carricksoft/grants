/*
 * Copyright (c)  13 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

@Component
public class CountryCommandConverterImpl implements Converter<CountryCommand, Country> {

    @Override
    public Country convert(CountryCommand source) {
        Country target = new Country();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }


}
