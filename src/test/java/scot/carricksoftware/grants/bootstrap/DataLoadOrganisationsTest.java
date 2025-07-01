package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadOrganisationsTest {

    private DataLoadOrganisations dataLoadOrganisations;


    @Mock
    private DataLoadCertificateAuthorities dataLoadCertificateAuthoritiesMock;

    @Mock
    private DataLoadRegistrationAuthorities dataLoadRegistrationAuthoritiesMock;

    @BeforeEach
    public void setUp() {
        dataLoadOrganisations = new DataLoadOrganisations(dataLoadCertificateAuthoritiesMock, dataLoadRegistrationAuthoritiesMock);
    }

    @Test
    void certificateAuthoritiesAreLoadedTest() {
        dataLoadOrganisations.load();
        verify(dataLoadCertificateAuthoritiesMock).load();
    }

    @Test
    void registrationAuthoritiesAreLoadedTest() {
        dataLoadOrganisations.load();
        verify(dataLoadRegistrationAuthoritiesMock).load();
    }

}
