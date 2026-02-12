/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class PlaceTextCommandTest {

    private PlaceTextCommand placeTextCommand;

    @BeforeEach
    void setUp() {
        placeTextCommand = new PlaceTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(placeTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        placeTextCommand.setId(id);
        assertEquals(id, placeTextCommand.getId());
    }

    @Test
    void getPlaceTest() {
        assertNull(placeTextCommand.getPlace());
    }

    @Test
    void setPlaceTest() {
        Place place = GetRandomPlace();
        placeTextCommand.setPlace(place);
        assertEquals(place, placeTextCommand.getPlace());
    }

    @Test
    void getLevelTest() {
        assertNull(placeTextCommand.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        placeTextCommand.setLevel(level);
        assertEquals(level, placeTextCommand.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(placeTextCommand.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        placeTextCommand.setOrder(order);
        assertEquals(order, placeTextCommand.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(placeTextCommand.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        placeTextCommand.setHeading(heading);
        assertEquals(heading, placeTextCommand.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(placeTextCommand.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        placeTextCommand.setContent(content);
        assertEquals(content, placeTextCommand.getContent());
    }

}