package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


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


    @BeforeEach
    public void setup() {
        dataLoadCertificates = new DataLoadCertificates(organisationServiceMock, birthCertificateServiceMock, personServiceMock, deathCertificateServiceMock);
    }

    @Test
    void DeathCertificateIsCreatedTest() {
        dataLoadCertificates.load();
        verify(deathCertificateServiceMock).saveDeathCertificateCommand(any());
    }

}