
/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 14:33.
 *
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;


@ExtendWith(MockitoExtension.class)
public class PlaceTest {

    private Place place;

    @Mock
    private Country countryMock;

    @Mock
    private Region regionMock;


    @BeforeEach
    public void setUp() {
        place = new Place();
    }

    @Test
    public void getIdTest() {
        assertNull(place.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        place.setId(id);
        assertEquals(id, place.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(place.getName());
    }

    @Test
    public void setLastNameTest() {
        String name = GetRandomString();
        place.setName(name);
        assertEquals(name, place.getName());
    }

    @Test
    public void getRegionTest() {
        assertNull(place.getRegion());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        place.setRegion(region);
        assertEquals(region, place.getRegion());
    }

    @Test
    public void getCensusesTest() {
        assertTrue(place.getCensuses().isEmpty());
    }

    @Test
    public void setCensusesTest() {
        List<Census> censuses = new ArrayList<>();
        censuses.add(GetRandomCensus());
        place.setCensuses(censuses);
        assertEquals(censuses, place.getCensuses());
    }

    @Test
    public void getPLaceImagesTest() {
        assertTrue(place.getPlaceImages().isEmpty());
    }

    @Test
    public void setPlaceImagesTest() {
        List<PlaceImage> placeImages = new ArrayList<>();
        placeImages.add(GetRandomPlaceImage());
        place.setPlaceImages(placeImages);
        assertEquals(placeImages, place.getPlaceImages());
    }

    @Test
    public void getPLaceTextsTest() {
        assertTrue(place.getPlaceTexts().isEmpty());
    }

    @Test
    public void setPlaceTextsTest() {
        List<PlaceText> placeTexts = new ArrayList<>();
        placeTexts.add(GetRandomPlaceText());
        place.setPlaceTexts(placeTexts);
        assertEquals(placeTexts, place.getPlaceTexts());
    }

    @Test
    public void toStringTest() {
        String string = GetRandomString();
        String string2 = GetRandomString();
        String string3 = GetRandomString();

        place.setName(string3);
        when(regionMock.getName()).thenReturn(string);
        when(regionMock.getCountry()).thenReturn(countryMock);
        when(countryMock.getName()).thenReturn(string2);

        place.setRegion(regionMock);

        assertEquals(string3 + ", "
                + string + ", "
                + string2, place.toString());
    }


}
