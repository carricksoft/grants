/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.ArrayList;
import java.util.List;

public class PlaceCommandTest {

    PlaceCommand command;

    @BeforeEach
    public void setUp() {
        command = new PlaceCommandImpl();
    }

    @Test
    public void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }


    @Test
    public void getRegionTest() {
        assertNull(command.getName());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }

    @Test
    public void getCensusesTest() {
        assertTrue(command.getCensuses().isEmpty());
    }

    @Test
    public void setCensusesTest() {
        List<Census> censuses = new ArrayList<>();
        censuses.add(GetRandomCensus());
        command.setCensuses(censuses);
        assertEquals(censuses, command.getCensuses());
    }

    @Test
    public void setPlaceImagesTest() {
        List<PlaceImage> placeImages = new ArrayList<>();
        placeImages.add(GetRandomPlaceImage());
        command.setPlaceImages(placeImages);
        assertEquals(placeImages, command.getPlaceImages());
    }

    @Test
    public void getPLaceTextsTest() {
        assertTrue(command.getPlaceTexts().isEmpty());
    }

    @Test
    public void setPlaceTextsTest() {
        List<PlaceText> placeTexts = new ArrayList<>();
        placeTexts.add(GetRandomPlaceText());
        command.setPlaceTexts(placeTexts);
        assertEquals(placeTexts, command.getPlaceTexts());
    }


}