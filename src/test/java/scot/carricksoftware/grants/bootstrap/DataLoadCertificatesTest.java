package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PlaceService placeServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock,
                deathCertificateServiceMock,
                personServiceMock,
                placeServiceMock);
    }

    @Test
    public void birthCertificatesAreLoadedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        Place place = GetRandomPlace();
        when(placeServiceMock.findById(1L)).thenReturn(place);

        ArgumentCaptor<BirthCertificateCommand> captor = ArgumentCaptor.forClass(BirthCertificateCommand.class);

        dataLoadCertificates.load();

        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getNewBorn());
        assertEquals(place, captor.getValue().getCertificateIssuedAt());
        assertEquals("999", captor.getValue().getCertificateNumber());
        assertEquals("25/01/1953", captor.getValue().getCertificateDate());
    }

    @Test
    public void deathCertificatesAreLoadedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        ArgumentCaptor<DeathCertificate> captor = ArgumentCaptor.forClass(DeathCertificate.class);

        dataLoadCertificates.load();

        verify(deathCertificateServiceMock).save(captor.capture());
        assertEquals(person, captor.getValue().getDeceased());

    }


}