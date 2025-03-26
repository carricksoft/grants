package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

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
        dataLoadCertificates.load();
        verify(birthCertificateServiceMock).save(any(BirthCertificate.class));
    }

    @Test
    public void deathCertificatesAreLoadedTest() {
        dataLoadCertificates.load();
        verify(deathCertificateServiceMock).save(any(DeathCertificate.class));
    }


}