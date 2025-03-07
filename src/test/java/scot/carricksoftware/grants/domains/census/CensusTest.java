package scot.carricksoftware.grants.domains.census;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CensusTest {


    private Census census;


    @Before
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getIdTest() {
        assertNull(census.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        census.setId(id);
        assertEquals(id, census.getId());
    }


}