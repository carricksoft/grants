/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddAttributesTest {

    private AddAttributes addAttributes;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private OrganisationService organisationServiceMock;

    @BeforeEach
    void setUp() {
        addAttributes = new AddAttributesImpl(personServiceMock, placeServiceMock, organisationServiceMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(addAttributes);
    }
}