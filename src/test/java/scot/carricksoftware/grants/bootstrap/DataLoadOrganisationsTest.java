package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadOrganisationsTest {

    private DataLoadOrganisations dataLoadOrganisations;

    @Mock
    private OrganisationService organisationServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadOrganisations = new DataLoadOrganisations(organisationServiceMock);
    }

    @Test
    void certificateSourcesIsLoadedTest() {
        ArgumentCaptor<OrganisationCommand> captor = ArgumentCaptor.forClass(OrganisationCommand.class);
        dataLoadOrganisations.load();
        verify(organisationServiceMock, atLeast(1)).saveOrganisationCommand(captor.capture());
        for (OrganisationCommand command : captor.getAllValues()) {
            if (command.getName().equals("General Register Office For Scotland")) {
                assertTrue(true);
                return;
            }
        }
    }

    @Test
    void registrationAuthorityIsLoadedTest() {
        ArgumentCaptor<OrganisationCommand> captor = ArgumentCaptor.forClass(OrganisationCommand.class);
        dataLoadOrganisations.load();
        verify(organisationServiceMock, atLeast(1)).saveOrganisationCommand(captor.capture());
        for (OrganisationCommand command : captor.getAllValues()) {
            if (command.getName().equals("Registration Authority")) {
                assertTrue(true);
                return;
            }
        }
    }
}
