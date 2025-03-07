package scot.carricksoftware.grants.domains.twopersons.divorce;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.twopersons.Divorce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

public class DivorceTest {

    private Divorce divorce;


    @Before
    public void setUp() {
        divorce = new Divorce();
    }

    @Test
    public void getIdTest() {
        assertNull(divorce.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        divorce.setId(id);
        assertEquals(id, divorce.getId());
    }


}