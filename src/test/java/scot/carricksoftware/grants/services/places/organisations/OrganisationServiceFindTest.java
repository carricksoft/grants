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
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.repositories.places.OrganisationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
public class OrganisationServiceFindTest {

    OrganisationService organisationService;

    @Mock
    OrganisationRepository organisationRepositoryMock;

    @Mock
    OrganisationConverterImpl organisationConverterMock;

    @Mock
    OrganisationCommandConverterImpl organisationCommandConverterMock;

    @BeforeEach
    public void setUp() {
        organisationService = new OrganisationServiceImpl(organisationRepositoryMock,
                organisationConverterMock,
                organisationCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Organisation> organisations = new ArrayList<>();
        organisations.add(GetRandomOrganisation());
        when(organisationRepositoryMock.findAll()).thenReturn(organisations);
        assertEquals(organisations, organisationService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Organisation organisation = GetRandomOrganisation();
        Optional<Organisation> organisationOptional = Optional.of(organisation);
        when(organisationRepositoryMock.findById(id)).thenReturn(organisationOptional);
        assertEquals(organisation, organisationService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Organisation> empty = Optional.empty();
        when(organisationRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(organisationService.findById(id));
    }

}