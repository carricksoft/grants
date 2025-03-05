package scot.carricksoftware.grants.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DataLoadCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private PersonService personServiceMock;

    @Before
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock, personServiceMock);
    }

    @Test
    public void aNewCertificateIsGeneratedTest() {
        Person person = GetRandomPerson();
        when(personServiceMock.findById(1L)).thenReturn(person);
        ArgumentCaptor<BirthCertificateCommandImpl> certificateCaptor = ArgumentCaptor.forClass(BirthCertificateCommandImpl.class);
        dataLoadCertificates.load();
        verify(birthCertificateServiceMock, atLeast(1)).saveBirthCertificateCommand(certificateCaptor.capture());
        boolean found = false;
        for (BirthCertificateCommandImpl certificate : certificateCaptor.getAllValues()) {
            if (certificate.getPerson().toString().equals(person.toString())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

}