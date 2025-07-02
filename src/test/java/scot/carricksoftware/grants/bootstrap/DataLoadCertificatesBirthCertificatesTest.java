package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesBirthCertificatesTest {

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

    @Mock
    private Person fatherMock;

    @Mock
    private Person motherMock;

    @Mock
    private Person newBornMock;

    @Mock
    private Place placeMock;

    @Mock
    private Organisation certificateSourceMock;

    @Mock
    private Organisation registrationAuthorityMock;


    @BeforeEach
    public void setup() {
        dataLoadCertificates = new DataLoadCertificates(
                organisationServiceMock,
                birthCertificateServiceMock,
                personServiceMock,
                placeServiceMock,
                deathCertificateServiceMock);
    }

    @Test
    void birthCertificateIsCreatedTest() {
        ArgumentCaptor<BirthCertificateCommand> captor = ArgumentCaptor.forClass(BirthCertificateCommand.class);
        when(personServiceMock.findById(1L)).thenReturn(fatherMock);
        when(personServiceMock.findById(2L)).thenReturn(motherMock);
        when(personServiceMock.findById(3L)).thenReturn(newBornMock);
        when(placeServiceMock.findById(1L)).thenReturn(placeMock);
        when(certificateSourceMock.getName()).thenReturn("Source");
        when(registrationAuthorityMock.getName()).thenReturn("Authority");
        when(organisationServiceMock.findById(1L)).thenReturn(certificateSourceMock);
        when(organisationServiceMock.findById(2L)).thenReturn(registrationAuthorityMock);


        dataLoadCertificates.load();

        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals("999", captor.getValue().getCertificateNumber());
        assertEquals("25/01/1953", captor.getValue().getCertificateDate());
        assertEquals(CertificateType.EXTRACT, captor.getValue().getCertificateType());
        assertEquals("Authority", captor.getValue().getRegistrationAuthority().getName());
        assertEquals("01", captor.getValue().getVolume());
        assertEquals("02", captor.getValue().getNumber());
        assertEquals("Source", captor.getValue().getCertificateSource().getName());
        assertEquals(newBornMock, captor.getValue().getNewBorn());
        assertEquals(Sex.MALE, captor.getValue().getSex());
        assertEquals("25/01/1953 01:01", captor.getValue().getWhenBorn());
        assertEquals(fatherMock, captor.getValue().getFather());
        assertEquals("Untracked Father", captor.getValue().getUntrackedFather());
        assertEquals("Edinburgh", captor.getValue().getUntrackedWhereBorn());
        assertEquals(placeMock, captor.getValue().getWhereBorn());
        assertEquals(motherMock, captor.getValue().getMother());
        assertEquals(fatherMock, captor.getValue().getInformant());
        assertEquals("Untracked Informant", captor.getValue().getUntrackedInformant());
        assertEquals("Qualification", captor.getValue().getInformantQualification());
        assertEquals("Where Registered", captor.getValue().getWhereRegistered());
        assertEquals("22/01/1978", captor.getValue().getWhenRegistered());
        assertEquals("57 Back Street, Edinburgh", captor.getValue().getUntrackedFatherUsualResidence());
        assertEquals(placeMock, captor.getValue().getFatherUsualResidence());
        assertEquals("2 Wilson Avenue, Edinburgh", captor.getValue().getInformantResidence());
        assertEquals(placeMock, captor.getValue().getFatherUsualResidence());
        assertEquals("92 Broughton Road, Edinburgh", captor.getValue().getUntrackedMotherUsualResidence());
        assertEquals(placeMock, captor.getValue().getMotherUsualResidence());
    }


}