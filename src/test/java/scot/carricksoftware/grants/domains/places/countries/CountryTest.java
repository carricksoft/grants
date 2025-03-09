package scot.carricksoftware.grants.domains.places.countries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

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


}