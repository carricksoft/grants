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
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock,
                deathCertificateServiceMock,
                personServiceMock);
    }

    @Test
    public void birthCertificatesAreLoadedTest() {

        ArgumentCaptor<BirthCertificateCommand> captor = ArgumentCaptor.forClass(BirthCertificateCommand.class);

        dataLoadCertificates.load();

        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals("new born", captor.getValue().getNewBorn().getFirstName());
        assertEquals("certificate source", captor.getValue().getCertificateSource().getName());
        assertEquals("999", captor.getValue().getCertificateNumber());
        assertEquals("25/01/1953", captor.getValue().getCertificateDate());
        assertEquals(CertificateType.EXTRACT, captor.getValue().getCertificateType());
        assertEquals("registration authority", captor.getValue().getRegistrationAuthority().getName());
        assertEquals("01", captor.getValue().getNumber());
        assertEquals("1953", captor.getValue().getVolume());
        assertEquals(Sex.MALE, captor.getValue().getSex());
        assertEquals("25/01/1953 01:01", captor.getValue().getWhenBorn());
        assertEquals("where born", captor.getValue().getWhereBorn());
        assertEquals("fatherRank", captor.getValue().getFatherRank());
        assertEquals("untrackedFather", captor.getValue().getUntrackedFather());
        assertEquals("father", captor.getValue().getFather().getFirstName());
        assertEquals("mother", captor.getValue().getMother().getFirstName());
        assertEquals("date and place of marriage", captor.getValue().getDateAndPlaceOfMarriage());

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