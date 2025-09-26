/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class ImageCommandConverterTest {

    private ImageCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new ImageCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        String name = GetRandomString();
        String imageString = GetRandomString();
        byte[] imageData = imageString.getBytes();
        String filename = GetRandomString();

        ImageCommand source = new ImageCommandImpl();

        source.setId(Id);
        source.setName(name);
        source.setImageData(imageData);
        source.setFileName(filename);


        Image target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(name, target.getName());
        assertArrayEquals(imageData, target.getImageData());
        assertEquals(filename,target.getFileName());
    }
}