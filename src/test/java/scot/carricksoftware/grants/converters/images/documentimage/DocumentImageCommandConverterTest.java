/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.documentimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentImageCommandConverterTest {

    private DocumentImageCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DocumentImageCommandConverterImpl();
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


        DocumentImageCommand source = new DocumentImageCommandImpl();

        source.setId(Id);
        source.setImage(image);
        source.setLevel(level);
        source.setOrder(order);
        source.setCaption(caption);
        source.setHeight(height);
        source.setWidth(width);


        DocumentImage target = converter.convert(source);

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