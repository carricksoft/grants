package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadPeopleTest {

    private DataLoadPeople dataLoadPeople;


    @Mock
    private PersonServiceImpl personServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadPeople = new DataLoadPeople(personServiceMock);
    }

    @Test
    public void dadIsCreatedTest() {
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        dataLoadPeople.load();
        verify(personServiceMock, atLeast(2)).save(captor.capture());

        boolean found = false;
        for (Person person : captor.getAllValues()) {
            if (person.getFirstName().equals("Andrew") &&
                    person.getLastName().equals("Grant") &&
                    person.getCertifiedYearOfBirth().equals("1920") &&
                    person.getRecordedYearOfBirth().equals("1925")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }


    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void mumIsCreatedTest() {
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        dataLoadPeople.load();
        verify(personServiceMock, atLeast(2)).save(captor.capture());
        boolean found = false;
        for (Person person : captor.getAllValues()) {
            if (person.getFirstName().equals("Dorothy") &&
                    person.getLastName().equals("Bramall") &&
                    person.getCertifiedYearOfBirth().equals("1910") &&
                    person.getRecordedYearOfBirth().equals("1915")) {
                found = true;
                break;
            }

        }
        assertTrue(found);
    }

    @Test
    public void iAmCreatedTest() {
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        dataLoadPeople.load();
        verify(personServiceMock, atLeast(3)).save(captor.capture());
        boolean found = false;
        for (Person person : captor.getAllValues()) {
            if (person.getFirstName().equals("Andrew Peter") &&
                    person.getLastName().equals("Grant") &&
                    person.getCertifiedYearOfBirth().equals("1953") &&
                    person.getRecordedYearOfBirth().equals("1953")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

}