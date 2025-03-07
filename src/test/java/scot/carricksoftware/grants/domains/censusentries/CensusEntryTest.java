package scot.carricksoftware.grants.domains.censusentries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CensusEntryTest {


    private CensusEntry censusEntry;


    @Before
    public void setUp() {
        censusEntry = new CensusEntry();
    }

    @Test
    public void getIdTest() {
        assertNull(censusEntry.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        censusEntry.setId(id);
        assertEquals(id, censusEntry.getId());
    }


}