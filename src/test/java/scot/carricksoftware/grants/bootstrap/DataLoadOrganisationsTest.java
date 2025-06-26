package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class DataLoadOrganisationsTest {

    private DataLoadOrganisations dataLoadOrganisations;

    @Mock
    private OrganisationService organisationServiceMock;

    @BeforeEach
    public void setup() {
        dataLoadOrganisations = new DataLoadOrganisations(organisationServiceMock);
    }

    @Test
    void certificateSourceIsCreated() {
        ArgumentCaptor<OrganisationCommand> captor = ArgumentCaptor.forClass(OrganisationCommand.class);
        dataLoadOrganisations.load();

        verify(organisationServiceMock, atLeast(2)).saveOrganisationCommand(captor.capture());

        List<OrganisationCommand> organisationCommands = captor.getAllValues();
        boolean found = false;
        for (OrganisationCommand organisationCommand : organisationCommands) {
            if (organisationCommand.getName().equals("General Register Office For Scotland")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void registrationAuthorityIsCreated() {
        ArgumentCaptor<OrganisationCommand> captor = ArgumentCaptor.forClass(OrganisationCommand.class);
        dataLoadOrganisations.load();

        verify(organisationServiceMock, atLeast(2)).saveOrganisationCommand(captor.capture());

        List<OrganisationCommand> organisationCommands = captor.getAllValues();
        boolean found = false;
        for (OrganisationCommand organisationCommand : organisationCommands) {
            if (organisationCommand.getName().equals("Registration Authority")) {
                found = true;
            }
        }
        assertTrue(found);
    }


}