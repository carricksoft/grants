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
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverter;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverter;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.UpdateCertifiedYearOfDeath;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.certificates.deathcertificate.DeathCertificateCommandValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateFormControllerValidationTest {

    @SuppressWarnings("unused")
    private DeathCertificateFormController deathCertificateController;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private DeathCertificateCommandConverter deathCertificateCommandConverterMock;

    @Mock
    private DeathCertificateConverter deathCertificateConverterMock;


    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private DeathCertificateCommandValidator deathCertificateCommandValidatorMock;

    @Mock
    private Model modelMock;

    @Mock
    private UpdateCertifiedYearOfDeath updateCertifiedYearOfDeathMock;

    @Mock
    CapitaliseDeathCertificate capitaliseDeathCertificateMock;


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
    }


    @Test
    public void saveOrUpdateValidationTest() {
        DeathCertificateCommand deathCertificateCommand = new DeathCertificateCommandImpl();
        deathCertificateCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(deathCertificateServiceMock.saveDeathCertificateCommand(deathCertificateCommand)).thenReturn(deathCertificateCommand);

        deathCertificateController.saveOrUpdate(deathCertificateCommand, bindingResultMock, modelMock);

        verify(deathCertificateCommandValidatorMock).validate(deathCertificateCommand, bindingResultMock);
    }


}