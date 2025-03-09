package scot.carricksoftware.grants.domains.people;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


public class PersonTest {


    private Person person;


    @Before
    public void setUp() {
        person = new Person();
    }

    @Test
    public void getIdTest() {
        assertNull(person.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        person.setId(id);
        assertEquals(id, person.getId());
    }

    @Test
    public void getFirstnameTest() {
        assertNull(person.getFirstName());
    }

    @Test
    public void setFirstNameTest() {
        String firstName = GetRandomString();
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertNull(person.getLastName());
    }

    @Test
    public void setLastNameTest() {
        String lastName = GetRandomString();
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }
}