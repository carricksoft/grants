/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class AppendixImageCommandTest {

    private AppendixImageCommand command;

    @BeforeEach
    void setUp() {
        command = new AppendixImageCommandImpl();
    }

    @Test
    public void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    public void getCaptionTest() {
        assertNull(command.getCaption());
    }

    @Test
    public void setCaptionTest() {
        String caption = GetRandomString();
        command.setCaption(caption);
        assertEquals(caption, command.getCaption());
    }

    @Test
    public void getHeightTest() {
        assertNull(command.getHeight());
    }

    @Test
    public void setHeightTest() {
        String height = GetRandomString();
        command.setHeight(height);
        assertEquals(height, command.getHeight());
    }

    @Test
    public void getWidthTest() {
        assertNull(command.getWidth());
    }

    @Test
    public void setWidthTest() {
        String width = GetRandomString();
        command.setWidth(width);
        assertEquals(width, command.getWidth());
    }

    @Test
    public void getImageTest() {
        assertNull(command.getImage());
    }

    @Test
    public void setImageTest() {
        Image image = new Image();
        command.setImage(image);
        assertEquals(image, command.getImage());
    }

    @Test
    public void getOrderTest() {
        assertNull(command.getOrder());
    }

    @Test
    public void setOrderTest() {
        String order = GetRandomString();
        command.setOrder(order);
        assertEquals(order, command.getOrder());
    }

    @Test
    public void getLevelTest() {
        assertNull(command.getLevel());
    }

    @Test
    public void setLevelTest() {
        String level = GetRandomString();
        command.setLevel(level);
        assertEquals(level, command.getLevel());
    }

}