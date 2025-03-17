/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;


public class PlaceCommandConverterImplTest {

    final PlaceCommandConverterImpl converter = new PlaceCommandConverterImpl();
    PlaceCommand source;

    @BeforeEach
    public void setUp() {
        source = new PlaceCommandImpl();
    }

    @Test
    public void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Region region = GetRandomRegion();
        source.setId(id);
        source.setName(name);
        source.setRegion(region);

        Place target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(region, target.getRegion());
    }
}