package scot.carricksoftware.grants.commands.places.countries;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

public class CountryCommandTest {

    CountryCommand command;
    @Before
    public void setUp() {
        command = new CountryCommandImpl();
    }

    @Test
    public void getIdTest() {
       assertNull(command.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id,command.getId());
    }

    @Test
    public void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name,command.getName());
    }


}