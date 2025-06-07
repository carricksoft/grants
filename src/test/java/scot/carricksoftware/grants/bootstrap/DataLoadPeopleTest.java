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
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getFirstName().equals("Andrew")));
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getLastName().equals("Grant")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getCertifiedYearOfBirth().equals("1920")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getRecordedYearOfBirth().equals("1925")));
    }


    @Test
    public void mumIsCreatedTest() {
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        dataLoadPeople.load();
        verify(personServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getFirstName().equals("Dorothy")));
        //noinspection SpellCheckingInspection
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getLastName().equals("Bramall")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getCertifiedYearOfBirth().equals("1910")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getRecordedYearOfBirth().equals("1915")));
    }

    @Test
    public void iAmCreatedTest() {
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        dataLoadPeople.load();
        verify(personServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getFirstName().equals("Andrew Peter")));
        assertTrue(captor.getAllValues().stream().anyMatch(person -> person.getLastName().equals("Grant")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getCertifiedYearOfBirth().equals("1953")));
        assertTrue(captor.getAllValues().stream().anyMatch(
                person -> person.getRecordedYearOfBirth().equals("1953")));
    }

}