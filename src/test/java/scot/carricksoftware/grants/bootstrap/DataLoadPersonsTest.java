package scot.carricksoftware.grants.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DataLoadPersonsTest {

    private DataLoadPersons dataLoadPersons;

    @Mock
    private PersonService personServiceMock;

    @Before
    public void setUp() {
        dataLoadPersons = new DataLoadPersons(personServiceMock);
    }

    @Test
    public void dadIsCreatedTest() {
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        dataLoadPersons.load();
        verify(personServiceMock, atLeast(2)).save(personCaptor.capture());
        boolean found = false;
        for (Person person : personCaptor.getAllValues()) {
            if (person.getFirstName().equals("Andrew") &&
                    person.getLastName().equals("Grant")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void mumIsCreatedTest() {
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        dataLoadPersons.load();
        verify(personServiceMock, atLeast(2)).save(personCaptor.capture());
        boolean found = false;
        for (Person person : personCaptor.getAllValues()) {
            if (person.getFirstName().equals("Dorothy") &&
                    person.getLastName().equals("Bramall")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
}