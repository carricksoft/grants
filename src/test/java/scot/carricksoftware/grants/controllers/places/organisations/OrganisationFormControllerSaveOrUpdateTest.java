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
import scot.carricksoftware.grants.cache.BMDCache;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverterImpl;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.validators.places.OrganisationCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrganisationFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private OrganisationFormControllerImpl organisationController;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private OrganisationCommandConverterImpl organisationCommandConverterMock;

    @Mock
    private OrganisationConverterImpl organisationConverterMock;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    OrganisationCommandValidator organisationCommandValidatorMock;

    @Mock
    private BMDCache bmdCacheMock;

    private OrganisationCommand organisationCommand;


    @BeforeEach
    public void setUp() {
        organisationController = new OrganisationFormControllerImpl(organisationServiceMock,
                organisationCommandConverterMock,
                organisationConverterMock,
                capitaliseStringMock,
                organisationCommandValidatorMock,
                bmdCacheMock);
        organisationCommand = new OrganisationCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        organisationCommand.setId(id);
        when(organisationServiceMock.saveOrganisationCommand(any(OrganisationCommand.class))).thenReturn(organisationCommand);
        assertEquals("redirect:/organisation/4/show", organisationController.saveOrUpdate(organisationCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        organisationCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("organisation/form", organisationController.saveOrUpdate(organisationCommand, bindingResultMock, modelMock));
    }

    @Test
    public void CleaningTakesPlaceTest() {
        OrganisationCommand organisationCommand = new OrganisationCommandImpl();
        organisationCommand.setId(4L);
        organisationCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(organisationServiceMock.saveOrganisationCommand(any(OrganisationCommand.class))).thenReturn(organisationCommand);
        organisationController.saveOrUpdate(organisationCommand, bindingResultMock, modelMock);
        verify(capitaliseStringMock).capitalise("england");
    }


}