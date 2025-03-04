package scot.carricksoftware.grants.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomValues.*;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DataLoadCensusTest {

    private DataLoadCensus dataLoadCensus;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusEntryService censusEntryServiceMock;


    @Before
    public void setUp() {
        dataLoadCensus = new DataLoadCensus(placeServiceMock, censusServiceMock, personServiceMock, censusEntryServiceMock);
    }

    @Test
    public void censusWasCreated() {
        CensusCommand censusCommand = new CensusCommand();
        Place place = GetRandomPlace();
        when(censusServiceMock.saveCensusCommand(any())).thenReturn(censusCommand);
        when(placeServiceMock.findById(1L)).thenReturn(place);
        ArgumentCaptor<CensusCommand> censusCommandCaptor = ArgumentCaptor.forClass(CensusCommand.class);
        dataLoadCensus.load();
        verify(censusServiceMock, atLeast(1)).saveCensusCommand(censusCommandCaptor.capture());

        boolean found = false;
        for (CensusCommand   censusCommandCaptured : censusCommandCaptor.getAllValues()) {
            if (censusCommandCaptured.getPlace().toString().equals(place.toString()) &&
                    censusCommandCaptured.getDate().equals(LocalDate.now().format(ApplicationConstants.FORMATTER))) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

    @Test
    public void censusEntryWasCreated() {

        Census census = GetRandomCensus();
    Person person = GetRandomPerson();
    when(censusServiceMock.findById(1L)).thenReturn(census);
    when(personServiceMock.findById(1L)).thenReturn(person);


        ArgumentCaptor<CensusEntryCommand> censusEntryCommandCaptor = ArgumentCaptor.forClass(CensusEntryCommand.class);
        dataLoadCensus.load();
        verify(censusEntryServiceMock, atLeast(1)).saveCensusEntryCommand(censusEntryCommandCaptor.capture());

        boolean found = false;
        for (CensusEntryCommand   censusCommandCaptured : censusEntryCommandCaptor.getAllValues()) {
            if (censusCommandCaptured.getOtherPerson().equals("Dad") &&
                    censusCommandCaptured.getPerson().toString().equals(person.toString())  &&
                    censusCommandCaptured.getCensus().toString().equals(census.toString()))
            {
                found = true;
                break;
            }
        }

        assertTrue(found);

    }



}