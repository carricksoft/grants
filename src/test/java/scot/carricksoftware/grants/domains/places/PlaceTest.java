
/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 14:33.
 *
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

public class PlaceTest {

    private Place place;


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


}
