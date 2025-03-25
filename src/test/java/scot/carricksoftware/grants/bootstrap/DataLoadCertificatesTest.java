package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.DeathCertificateService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadCertificatesTest {

    private DataLoadCertificates dataLoadCertificates;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;


    @BeforeEach
    public void setUp() {
        dataLoadCertificates = new DataLoadCertificates(birthCertificateServiceMock, deathCertificateServiceMock);
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