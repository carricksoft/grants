package scot.carricksoftware.grants.domains.places.places;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PlaceTest {


    private Place place;

    @Before
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
    public void setNameTest() {
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
}