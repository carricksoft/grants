/*
 * Copyright (c)  13 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places;


import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.people.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

@SuppressWarnings("unused")
public interface CountryCommandConverter extends Converter<CountryCommand, Country> {

    @Override
    Country convert(@NotNull CountryCommand source);


}
