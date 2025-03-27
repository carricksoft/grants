package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadTwoPartyCertificatesTest {

    private DataLoadTwoPartyCertificates dataLoadTwoPartyCertificates;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadTwoPartyCertificates = new DataLoadTwoPartyCertificates(marriageCertificateServiceMock,
                divorceCertificateServiceMock);
    }

    @Test
    public void MarriageCertificatesAreLoadedTest() {
        ArgumentCaptor<MarriageCertificate> captor = ArgumentCaptor.forClass(MarriageCertificate.class);

        dataLoadTwoPartyCertificates.load();

        verify(marriageCertificateServiceMock).save(captor.capture());
    }

    @Test
    public void divorceCertificatesAreLoadedTest() {

        ArgumentCaptor<DivorceCertificate> captor = ArgumentCaptor.forClass(DivorceCertificate.class);

        dataLoadTwoPartyCertificates.load();

        verify(divorceCertificateServiceMock).save(captor.capture());
    }


}