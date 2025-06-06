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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.repositories.places.OrganisationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


@ExtendWith(MockitoExtension.class)
public class OrganisationServiceTest {

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

    @Mock
    Page<Organisation> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        organisationService.deleteById(id);
        verify(organisationRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(organisationRepositoryMock.count()).thenReturn(result);
        assertEquals(result, organisationService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Organisation> result = new ArrayList<>();
        Organisation organisation = GetRandomOrganisation();
        result.add(organisation);
        when(pageMock.getContent()).thenReturn(result);
        when(organisationRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, organisationService.getPagedOrganisations(0));
    }

    @Test
    public void getFindByNameTest() {
        String name = GetRandomString();
        Organisation organisation = GetRandomOrganisation();
        organisationService.findByName(name);
        when(organisationRepositoryMock.findByName(name)).thenReturn(Optional.of(organisation));
        assertEquals(organisation, organisationService.findByName(name));
    }


}