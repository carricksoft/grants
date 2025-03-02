/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.countries;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class CountryCommandConverterImplTest {

    final CountryCommandConverterImpl converter = new CountryCommandConverterImpl();
    CountryCommand source;

    @Before
    public void setUp() {
        source = new CountryCommand();
    }

    @Test
    public void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Set<Place> places = new HashSet<>();
        places.add(new Place());

        source.setId(id);
        source.setName(name);
        source.setPlaces(places);


        Country target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(places, target.getPlaces());

    }
}