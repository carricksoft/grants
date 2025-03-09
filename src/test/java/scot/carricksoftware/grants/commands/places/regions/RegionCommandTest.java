package scot.carricksoftware.grants.commands.places.regions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class RegionCommandTest {

    RegionCommand command;
    @Before
    public void setUp() {
        command = new RegionCommandImpl();
    }

    @Test
    public void getIdTest() {
       assertNull(command.getId());
    }




}