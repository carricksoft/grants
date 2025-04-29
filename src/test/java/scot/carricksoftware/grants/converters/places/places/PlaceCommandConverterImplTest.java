/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;


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
        List<Census> censuses = new ArrayList<>();
        censuses.add(GetRandomCensus());
        List<PlaceImage> placeImages = new ArrayList<>();
        placeImages.add(GetRandomPlaceImage());
        List<PlaceText> placeTexts = new ArrayList<>();
        placeTexts.add(GetRandomPlaceText());

        source.setCensuses(censuses);
        source.setId(id);
        source.setName(name);
        source.setRegion(region);
        source.setCensuses(censuses);
        source.setPlaceTexts(placeTexts);
        source.setPlaceImages(placeImages);

        Place target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(region, target.getRegion());
        assertEquals(censuses, target.getCensuses());
        assertEquals(placeTexts, target.getPlaceTexts());
        assertEquals(placeImages, target.getPlaceImages());
    }
}