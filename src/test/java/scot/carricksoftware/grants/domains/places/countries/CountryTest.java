package scot.carricksoftware.grants.domains.places.countries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CountryTest {


    private Country country;


    @Before
    public void setUp() {
        country = new Country();
    }

    @Test
    public void getIdTest() {
        assertNull(country.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        country.setId(id);
        assertEquals(id, country.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(country.getName());
    }

    @Test
    public void setLastNameTest() {
        String name = GetRandomString();
        country.setName(name);
        assertEquals(name, country.getName());
    }

    @Test
    public void getRegionsTest() {
        assertNull(country.getRegions());
    }

    @Test
    public void RegionsTest() {
        Set<Region> regionSet = new HashSet<>();
        regionSet.add(GetRandomRegion());
        country.setRegions(regionSet);
        assertEquals(regionSet, country.getRegions());
    }


}