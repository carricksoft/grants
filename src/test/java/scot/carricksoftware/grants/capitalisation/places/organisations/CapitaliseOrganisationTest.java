/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.organisations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitaliseOrganisationTest {

    private CapitaliseOrganisation capitaliseOrganisation;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseOrganisation = new CapitaliseOrganisationImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseNameTest() {
        OrganisationCommand organisationCommand = new OrganisationCommandImpl();
        organisationCommand.setName("lower");
        when(capitaliseStringMock.capitalise("lower")).thenReturn("Lower");
        capitaliseOrganisation.capitalise(organisationCommand);
        assertEquals("Lower",organisationCommand.getName());
    }
}