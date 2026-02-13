/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.placeText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.text.PlaceText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceCommandConverterTest {
    
    private PlaceTextCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PlaceTextCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Place place = GetRandomPlace();
        String order = GetRandomString();
        String level = GetRandomString();
        String heading = GetRandomString();
        String content = GetRandomString();

        PlaceTextCommand source = new PlaceTextCommandImpl();

        source.setId(Id);
        source.setPlace(place);
        source.setOrder(order);
        source.setLevel(level);
        source.setHeading(heading);
        source.setContent(content);

        PlaceText target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(place, target.getPlace());
        assertEquals(order, target.getOrder());
        assertEquals(level, target.getLevel());
        assertEquals(heading, target.getHeading());
        assertEquals(content, target.getContent());
    }
}