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
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

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
    private OrganisationService organisationServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock,
                deathCertificateServiceMock,
                personServiceMock,
                organisationServiceMock);
    }

    @Test
    public void birthCertificatesAreLoadedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        Organisation organisation = GetRandomOrganisation();
        when(organisationServiceMock.findById(1L)).thenReturn(organisation);

        ArgumentCaptor<BirthCertificateCommand> captor = ArgumentCaptor.forClass(BirthCertificateCommand.class);

        dataLoadCertificates.load();

        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getNewBorn());
        assertEquals(organisation, captor.getValue().getCertificateSource());
        assertEquals("999", captor.getValue().getCertificateNumber());
        assertEquals("25/01/1953", captor.getValue().getCertificateDate());
        assertEquals(CertificateType.EXTRACT, captor.getValue().getCertificateType());
        assertEquals(organisation, captor.getValue().getRegistrationAuthority());
        assertEquals("01", captor.getValue().getNumber());
        assertEquals("1953", captor.getValue().getVolume());
        assertEquals(Sex.MALE, captor.getValue().getSex());
        assertEquals("25/01/1953", captor.getValue().getWhenBorn());
        assertEquals("Edinburgh", captor.getValue().getWhereBorn());
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