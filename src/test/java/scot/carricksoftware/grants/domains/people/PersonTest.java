package scot.carricksoftware.grants.domains.people;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PersonTest {


    private Person person;


    @Before
    public void setUp() {
    person = new  Person();
    }

    @Test
    public void getIdTest(){
        assertNull(person.getId());
    }

    @Test
    public void setIdTest(){
        Long id = GetRandomLong();
        person.setId(id);
        assertEquals(id, person.getId());
    }
}