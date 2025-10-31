/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.appendiximage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class AppendixImageCommandConverterTest {

    private AppendixImageCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new AppendixImageCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Image image = new Image();
        String level = GetRandomString();
        String order = GetRandomString();
        String caption = GetRandomString();
        String height = GetRandomString();
        String width = GetRandomString();


        AppendixImageCommand source = new AppendixImageCommandImpl();

        source.setId(Id);
        source.setImage(image);
        source.setLevel(level);
        source.setOrder(order);
        source.setCaption(caption);
        source.setHeight(height);
        source.setWidth(width);


        AppendixImage target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(image, target.getImage());
        assertEquals(level, target.getLevel());
        assertEquals(order, target.getOrder());
        assertEquals(caption, target.getCaption());
        assertEquals(height, target.getHeight());
        assertEquals(width, target.getWidth());
    }
}