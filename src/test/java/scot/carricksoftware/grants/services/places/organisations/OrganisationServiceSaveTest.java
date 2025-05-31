/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.organisations;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.repositories.places.OrganisationRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


@ExtendWith(MockitoExtension.class)
public class OrganisationServiceSaveTest {

    OrganisationService organisationService;

    @Mock
    OrganisationRepository organisationRepositoryMock;

    @Mock
    OrganisationConverterImpl organisationConverterImplMock;

    @Mock
    OrganisationCommandConverterImpl organisationCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        organisationService = new OrganisationServiceImpl(organisationRepositoryMock,
                organisationConverterImplMock,
                organisationCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        Organisation organisation = new Organisation();
        organisation.setName(GetRandomString());

        when(organisationRepositoryMock.save(organisation)).thenReturn(organisation);

        assertEquals(organisation, organisationService.save(organisation));
    }

    @Test
    public void saveOrganisationCommandTest() {
        Organisation organisation = GetRandomOrganisation();
        OrganisationCommand organisationCommand = new OrganisationCommandImpl();
        when(organisationCommandConverterImplMock.convert(organisationCommand)).thenReturn(organisation);
        when(organisationRepositoryMock.save(organisation)).thenReturn(organisation);
        when(organisationConverterImplMock.convert((organisation))).thenReturn(organisationCommand);

        assertEquals(organisationCommand, organisationService.saveOrganisationCommand(organisationCommand));
    }


}