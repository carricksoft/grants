/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.organisations;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.validators.places.OrganisationCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrganisationFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private OrganisationFormControllerImpl organisationController;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private OrganisationCommandConverterImpl organisationCommandConverterMock;

    @Mock
    private OrganisationConverterImpl organisationConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    OrganisationCommand organisationCommandMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    OrganisationCommandValidator organisationCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        organisationController = new OrganisationFormControllerImpl(organisationServiceMock,
                organisationCommandConverterMock,
                organisationConverterMock,
                capitalisationMock,
                organisationCommandValidatorMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(organisationServiceMock.saveOrganisationCommand(any())).thenReturn(organisationCommandMock);
        when(organisationCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        organisationController.saveOrUpdate(organisationCommandMock, bindingResultMock, modelMock);
        verify(organisationCommandMock).setName(uName);
    }

    @Test
    public void saveOrUpdateValidationTest() {
        String name = "goat";
        String uName = "Goat";
        when(organisationServiceMock.saveOrganisationCommand(any())).thenReturn(organisationCommandMock);
        when(organisationCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        organisationController.saveOrUpdate(organisationCommandMock, bindingResultMock, modelMock);
        verify(organisationCommandValidatorMock).validate(organisationCommandMock, bindingResultMock);
    }


}