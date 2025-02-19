/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@Component
class CountryConverterImplTest {

    final CountryConverterImpl converter = new CountryConverterImpl();
    Country source;

    @BeforeEach
    void setUp() {
        source = new Country();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();

        source.setId(id);
        source.setName(name);

        CountryCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
    }

}