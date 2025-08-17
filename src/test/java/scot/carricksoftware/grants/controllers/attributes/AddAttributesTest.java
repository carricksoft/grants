/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.attributes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.cache.BMDCache;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAttributesTest {

    private AddAttributes addAttributes;

    @Mock
    private BMDCache bmdCacheMock;


    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private Model modelMock;

    @BeforeEach
    void setUp() {
        addAttributes = new AddAttributesImpl(bmdCacheMock, organisationServiceMock);
    }

    @Test
    void AddBMDCertificatePeopleTest() {
        List<Person> peopleList = new ArrayList<>();
        addAttributes.AddBMDCertificate(modelMock);
        verify(modelMock).addAttribute("people", peopleList);
    }

    @Test
    void AddBMDCertificatePlacesTest() {
        List<Place> placeList = new ArrayList<>();
        addAttributes.AddBMDCertificate(modelMock);
        verify(modelMock).addAttribute("places", placeList);
    }

    @Test
    void AddBMDCertificateOrganisationsTest() {
        List<Organisation> organisationListList = new ArrayList<>();
        when(organisationServiceMock.findAll()).thenReturn(organisationListList);
        addAttributes.AddBMDCertificate(modelMock);
        verify(modelMock).addAttribute("organisations", organisationListList);
    }
}