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
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;
import scot.carricksoftware.grants.enums.census.CensusDate;
import scot.carricksoftware.grants.enums.censusentry.*;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.general.YesNo;
import scot.carricksoftware.grants.services.census.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class DataLoadCensusTest {

    private DataLoadCensus dataLoadCensus;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCensus = new DataLoadCensus(censusServiceMock,
                censusEntryServiceMock,
                placeServiceMock,
                personServiceMock);
    }

    @Test
    public void censusIsCreatedTest() {
        Place place = GetRandomPlace();
        ArgumentCaptor<CensusCommand> captor = ArgumentCaptor.forClass(CensusCommand.class);
        when(placeServiceMock.findById(1L)).thenReturn(place);
        dataLoadCensus.load();
        verify(censusServiceMock).saveCensusCommand(captor.capture());

        assertEquals(CensusDate.CENSUS_1881, captor.getValue().getCensusDate());
        assertEquals(captor.getValue().getPlace(), place);
        assertEquals(CensusBoundaryType.ISLAND, captor.getValue().getBoundaryType());
        assertEquals("2", captor.getValue().getInhabitedRooms());
        assertEquals("1", captor.getValue().getRoomsWithWindows());
        assertEquals("Percy Grant", captor.getValue().getFilledInBy());
        assertEquals("4", captor.getValue().getTotalRooms());
        assertEquals("52", captor.getValue().getRoomsOccupied());
        assertEquals("50", captor.getValue().getInhabitedHouses());
        assertEquals("51", captor.getValue().getUninhabitedHouses());
        assertEquals("9", captor.getValue().getPeopleInHouses());
    }

    @Test
    public void censusEntryIsCreatedTest() {
        ArgumentCaptor<CensusEntryCommand> captor = ArgumentCaptor.forClass(CensusEntryCommand.class);
        Census census = GetRandomCensus();
        Person person = GetRandomPerson();
        when(censusServiceMock.findById(1L)).thenReturn(census);
        when(personServiceMock.findById(1L)).thenReturn(person);

        dataLoadCensus.load();

        verify(censusEntryServiceMock).saveCensusEntryCommand(captor.capture());
        assertEquals("Archie Grant", captor.getValue().getName());
        assertEquals(census, captor.getValue().getCensus());
        assertEquals(person, captor.getValue().getPerson());
        assertEquals(CensusEntryRelationship.COUSIN, captor.getValue().getRelationship());
        assertEquals(CensusEntryCondition.MARRIED, captor.getValue().getCondition());
        assertEquals(CensusEntryGaelic.GAELIC, captor.getValue().getGaelic());
        assertEquals(CensusEntryWorker.WORKER, captor.getValue().getWorker());
        assertEquals("72", captor.getValue().getAge());
        assertEquals("Edinburgh", captor.getValue().getWhereBorn());
        assertEquals(Sex.MALE, captor.getValue().getSex());
        assertEquals("25/01", captor.getValue().getBirthDay());
        assertEquals("1953", captor.getValue().getBirthYear());
        assertEquals("AA Patrol", captor.getValue().getPersonalOccupation());
        assertEquals("Record Closed", captor.getValue().getNotes());
        assertEquals("4", captor.getValue().getChildrenBornAlive());
        assertEquals("3", captor.getValue().getChildrenStillAlive());
        assertEquals("1", captor.getValue().getChildrenWhoHaveDied());
        assertEquals("13", captor.getValue().getYearsCompletedMarriage());
        assertEquals("Chauffeur", captor.getValue().getIndustryOrService());
        assertEquals(YesNo.NO, captor.getValue().getWorkingAtHome());

    }


}