package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesDeathCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @SuppressWarnings("unused")
    private Person father;
    @SuppressWarnings("unused")
    private Person mother;
    @SuppressWarnings("unused")
    private Person deceased;
    @SuppressWarnings("unused")
    private Person spouse;
    @SuppressWarnings("unused")
    private Person informant;



    @BeforeEach
    public void setup() {
        dataLoadCertificates = new DataLoadCertificates(
                organisationServiceMock,
                birthCertificateServiceMock,
                personServiceMock,
                placeServiceMock,
                deathCertificateServiceMock);
        when(personServiceMock.findById(1L)).thenReturn(deceased);
        when(personServiceMock.findById(2L)).thenReturn(father);
        when(personServiceMock.findById(3L)).thenReturn(informant);
        when(personServiceMock.findById(4L)).thenReturn(mother);
        when(personServiceMock.findById(5L)).thenReturn(spouse);
    }

    @Test
    void DeathCertificateIsCreatedTest() {
        ArgumentCaptor<DeathCertificateCommand> captor = ArgumentCaptor.forClass(DeathCertificateCommand.class);

        dataLoadCertificates.load();
        verify(deathCertificateServiceMock).saveDeathCertificateCommand(captor.capture());
        assertEquals(deceased, captor.getValue().getDeceased());
        assertEquals(father, captor.getValue().getFather());
        assertEquals(mother, captor.getValue().getMother());
        assertEquals(spouse, captor.getValue().getSpouse());
        assertEquals(informant, captor.getValue().getInformant());
    }

}