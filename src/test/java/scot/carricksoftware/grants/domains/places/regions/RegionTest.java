package scot.carricksoftware.grants.domains.places.regions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Region;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RegionTest {


    private Region region;


    @Before
    public void setUp() {
        region = new Region();
    }

    @Test
    public void getIdTest() {
        assertNull(region.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        region.setId(id);
        assertEquals(id, region.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(region.getName());
    }

    @Test
    public void setLastNameTest() {
        String name = GetRandomString();
        region.setName(name);
        assertEquals(name, region.getName());
    }
}