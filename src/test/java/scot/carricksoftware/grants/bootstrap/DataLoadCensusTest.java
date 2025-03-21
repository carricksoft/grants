package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;

@ExtendWith(MockitoExtension.class)
public class DataLoadCensusTest {

    private DataLoadCensus dataLoadCensus;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private CensusService censusServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCensus = new DataLoadCensus(censusServiceMock, censusEntryServiceMock);
    }

    @Test
    public void censusIsCreatedTest() {
        ArgumentCaptor<CensusCommand> captor = ArgumentCaptor.forClass(CensusCommand.class);
        dataLoadCensus.load();
        verify(censusServiceMock).saveCensusCommand(captor.capture());
        assertEquals(captor.getValue().getDate(), LocalDate.now());
    }

    @Test
    public void censusEntryIsCreatedTest() {
        ArgumentCaptor<CensusEntryCommand> captor = ArgumentCaptor.forClass(CensusEntryCommand.class);
        Census census = GetRandomCensus();
        when(censusServiceMock.findById(1L)).thenReturn(census);
        dataLoadCensus.load();
        verify(censusEntryServiceMock).saveCensusEntryCommand(captor.capture());
        assertEquals("Archie Grant", captor.getValue().getName());
        assertEquals(census, captor.getValue().getCensus());
    }


}