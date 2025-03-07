package scot.carricksoftware.grants.domains.twopersons.marriage;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.twopersons.Marriage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

public class MarriageTest {

    private Marriage marriage;


    @Before
    public void setUp() {
        marriage = new Marriage();
    }

    @Test
    public void getIdTest() {
        assertNull(marriage.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        marriage.setId(id);
        assertEquals(id, marriage.getId());
    }


}