package scot.carricksoftware.grants.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;


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
    public void censusEntryWasCreated() {
        CensusCommand censusCommand = new CensusCommand();
        Place place = GetRandomPlace();
        when(censusServiceMock.saveCensusCommand(any())).thenReturn(censusCommand);
        when(placeServiceMock.findById(1L)).thenReturn(place);
        ArgumentCaptor<CensusCommand> censusCommandCaptor = ArgumentCaptor.forClass(CensusCommand.class);
        dataLoadCensus.load();
        verify(censusServiceMock, times(2)).saveCensusCommand(censusCommandCaptor.capture());

        assertEquals(censusCommandCaptor.getAllValues().get(0).getDate(), LocalDate.now().format(ApplicationConstants.FORMATTER));
        assertEquals(place, censusCommandCaptor.getAllValues().get(1).getPlace());


    }


}