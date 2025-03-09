package scot.carricksoftware.grants.commands.places.places;

import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.places.Region;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

public class PlaceCommandTest {

    PlaceCommand command;

    @Before
    public void setUp() {
        command = new PlaceCommandImpl();
    }

    @Test
    public void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }

    @Test
    public void getRegionTest() {
        assertNull(command.getRegion());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        command.setRegion(region);
        assertEquals(region, command.getRegion());
    }


}