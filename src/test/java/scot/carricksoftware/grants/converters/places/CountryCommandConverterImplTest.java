/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.people.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class CountryCommandConverterImplTest {

    final CountryCommandConverterImpl converter = new CountryCommandConverterImpl();
    CountryCommand source;

    @BeforeEach
    void setUp() {
        source = new CountryCommand();
    }

    @Test
    void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();

        source.setId(id);
        source.setName(name);


        Country target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());

    }
}