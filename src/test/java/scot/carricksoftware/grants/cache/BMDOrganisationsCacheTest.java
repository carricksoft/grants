/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
public class BMDOrganisationsCacheTest {
    
    @Mock
    PersonService personServiceMock;

    @Mock
    PlaceService placeServiceMock;

    @Mock
    OrganisationService organisationServiceMock;

    private BMDCache cache;

    private List<Organisation> organisationsList = null;

    @BeforeEach
    void setUp() {
        organisationsList = new ArrayList<>();
        organisationsList.add(GetRandomOrganisation());
        when(organisationServiceMock.findAll()).thenReturn(organisationsList);
        cache = new BMDCacheImpl(personServiceMock, placeServiceMock, organisationServiceMock);
    }

    @Test
    void nullOrganisationsTest() {
        assertEquals(organisationsList,cache.getOrganisations());
        verify(organisationServiceMock).findAll();
    }

    @Test
    void alreadyExistsTest() {
        assertEquals(organisationsList,cache.getOrganisations());
        assertEquals(organisationsList,cache.getOrganisations());
        verify(organisationServiceMock, times(1)).findAll();
    }

    @Test
    void invalidateTest() {
        assertEquals(organisationsList,cache.getOrganisations());
        cache.invalidateOrganisations();
        assertEquals(organisationsList,cache.getOrganisations());
        verify(organisationServiceMock, times(2)).findAll();
    }
}