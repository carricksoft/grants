/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverter;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceImageCommandConverterTest {

    private PlaceImageCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PlaceImageCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Place place = GetRandomPlace();
        Image image = new Image();
        String level = GetRandomString();
        String order = GetRandomString();
        String caption = GetRandomString();
        String height = GetRandomString();
        String width = GetRandomString();


        PlaceImageCommand source = new PlaceImageCommandImpl();

        source.setPlace(place);
        source.setId(Id);
        source.setImage(image);
        source.setLevel(level);
        source.setOrder(order);
        source.setCaption(caption);
        source.setHeight(height);
        source.setWidth(width);


        PlaceImage target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(place, target.getPlace());
        assertEquals(image, target.getImage());
        assertEquals(level, target.getLevel());
        assertEquals(order, target.getOrder());
        assertEquals(caption, target.getCaption());
        assertEquals(height, target.getHeight());
        assertEquals(width, target.getWidth());
    }
}