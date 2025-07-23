/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificate.CapitaliseDeathCertificate;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.UpdateCertifiedYearOfDeath;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.certificates.deathcertificate.DeathCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private DeathCertificateFormControllerImpl deathCertificateController;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private DeathCertificateCommandConverterImpl deathCertificateCommandConverterMock;

    @Mock
    private DeathCertificateConverterImpl deathCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private UpdateCertifiedYearOfDeath updateCertifiedYearOfDeathMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    CapitaliseDeathCertificate capitaliseDeathCertificateMock;

    @Mock
    private DeathCertificateCommandValidator deathCertificateCommandValidatorMock;

    private DeathCertificateCommand deathCertificateCommand;


    @BeforeEach
    public void setUp() {
        deathCertificateController = new DeathCertificateFormControllerImpl(deathCertificateServiceMock,
                deathCertificateCommandConverterMock,
                deathCertificateConverterMock,
                deathCertificateCommandValidatorMock,
                personServiceMock,
                placeServiceMock,
                organisationServiceMock,
                capitaliseDeathCertificateMock,
                updateCertifiedYearOfDeathMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        deathCertificateCommand.setId(id);
        when(deathCertificateServiceMock.saveDeathCertificateCommand(any(DeathCertificateCommand.class))).thenReturn(deathCertificateCommand);
        assertEquals("redirect:/deathCertificate/4/show", deathCertificateController.saveOrUpdate(deathCertificateCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        deathCertificateCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/deathCertificate/form", deathCertificateController.saveOrUpdate(deathCertificateCommand, bindingResultMock, modelMock));
    }

    @Test
    public void capitalisationIsAppliedTest() {
        when(deathCertificateServiceMock.saveDeathCertificateCommand(any(DeathCertificateCommand.class))).thenReturn(deathCertificateCommand);
        deathCertificateCommand.setId(4L);
        deathCertificateController.saveOrUpdate(deathCertificateCommand, bindingResultMock, modelMock);
        verify(capitaliseDeathCertificateMock).capitalise(deathCertificateCommand);
    }

    @Test
    public void yearOfDeathIsUpdatedTest() {
        when(deathCertificateServiceMock.saveDeathCertificateCommand(any(DeathCertificateCommand.class))).thenReturn(deathCertificateCommand);
        deathCertificateCommand.setId(4L);
        deathCertificateController.saveOrUpdate(deathCertificateCommand, bindingResultMock, modelMock);
        verify(updateCertifiedYearOfDeathMock).updateCertifiedYearOfDeath(deathCertificateCommand);
    }

}