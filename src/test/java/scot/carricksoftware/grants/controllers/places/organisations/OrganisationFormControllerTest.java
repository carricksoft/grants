/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.organisations;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.capitalisation.Capitalisation;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.validators.places.OrganisationCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisationCommand;


@ExtendWith(MockitoExtension.class)
public class OrganisationFormControllerTest {

    @SuppressWarnings("unused")
    private OrganisationFormControllerImpl organisationController;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private OrganisationCommandConverterImpl organisationCommandConverterMock;

    @Mock
    private OrganisationConverterImpl organisationConverterMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    private Model modelMock;

    @Mock
    OrganisationCommandValidator organisationCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        organisationController = new OrganisationFormControllerImpl(organisationServiceMock,
                organisationCommandConverterMock,
                organisationConverterMock,
                capitalisationMock,
                organisationCommandValidatorMock);
    }

    @Test
    public void getNewOrganisationTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("organisation/form", organisationController.getNewOrganisation(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("organisationCommand", stringCaptor.getValue());
        assertEquals("OrganisationCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void organisationEditTestEditTest() {
        Long id = GetRandomLong();
        Organisation organisation = GetRandomOrganisation();
        when(organisationServiceMock.findById(id)).thenReturn(organisation);

        assertEquals("organisation/form", organisationController.organisationEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.ORGANISATION_COMMAND, organisation);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Organisation organisation = GetRandomOrganisation();
        OrganisationCommand organisationCommand = GetRandomOrganisationCommand();

        when(organisationServiceMock.findById(id)).thenReturn(organisation);
        when(organisationConverterMock.convert(organisation)).thenReturn(organisationCommand);
        assertEquals("organisation/form", organisationController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.ORGANISATION_COMMAND, organisationCommand);
    }

}