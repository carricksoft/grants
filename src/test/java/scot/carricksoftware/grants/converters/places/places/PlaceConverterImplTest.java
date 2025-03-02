/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.places;

import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@Component
public class PlaceConverterImplTest {

    final PlaceConverterImpl converter = new PlaceConverterImpl();
    Place source;

    @Before
    public void setUp() {
        source = new Place();
    }

    @Test
    public void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Country country = GetRandomCountry();
        Region region = GetRandomRegion();
        source.setId(id);
        source.setName(name);
        source.setCountry(country);
        source.setRegion(region);


        PlaceCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(country, target.getCountry());
        assertEquals(region, target.getRegion());
        assertEquals(id, target.getId());
    }

}