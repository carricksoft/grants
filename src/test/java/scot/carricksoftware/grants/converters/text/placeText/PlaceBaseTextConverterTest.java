/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.placeText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.text.PlaceText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceBaseTextConverterTest {

    private PlaceTextConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PlaceTextConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Place place = GetRandomPlace();
        String order = GetRandomString();
        String level = GetRandomString();
        String heading = GetRandomString();
        String content = GetRandomString();
        PlaceText source = new PlaceText();

        source.setId(Id);
        source.setPlace(place);
        source.setOrder(order);
        source.setLevel(level);
        source.setHeading(heading);
        source.setOrder(order);
        source.setContent(content);

        PlaceTextCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(place, target.getPlace());
        assertEquals(order, target.getOrder());
        assertEquals(level, target.getLevel());
        assertEquals(heading, target.getHeading());
        assertEquals(content, target.getContent());
    }
}