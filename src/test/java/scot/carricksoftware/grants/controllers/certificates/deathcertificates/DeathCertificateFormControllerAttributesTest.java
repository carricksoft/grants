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
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificates.CapitaliseDeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.UpdateCertifiedYearOfDeath;
import scot.carricksoftware.grants.validators.certificates.deathcertificate.DeathCertificateCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateFormControllerAttributesTest {

    @SuppressWarnings("unused")
    private DeathCertificateFormControllerImpl deathCertificateFormController;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private DeathCertificateCommandConverterImpl deathCertificateCommandConverterMock;

    @Mock
    private DeathCertificateConverterImpl deathCertificateConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private CapitaliseDeathCertificateCommand capitaliseDeathCertificateCommandMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private DeathCertificateCommandValidatorImpl deathCertificateCommandValidatorImplMock;

    @Mock
    private UpdateCertifiedYearOfDeath updateCertifiedYearOfDeathMock;

    @Mock
    private DeathCertificateCommand deathCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;


    @BeforeEach
    public void setUp() {
        deathCertificateFormController = new DeathCertificateFormControllerImpl(deathCertificateServiceMock,
                deathCertificateCommandConverterMock,
                deathCertificateConverterMock,
                deathCertificateCommandValidatorImplMock,
                capitaliseDeathCertificateCommandMock,
                updateCertifiedYearOfDeathMock,
                addAttributesMock);
    }

    @Test
    public void newCertificateTest() {
        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.getNewDeathCertificate(modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void editCertificateTest() {
        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.deathCertificateEdit(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/deathCertificate/form",
                deathCertificateFormController.saveOrUpdate(deathCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(deathCertificateServiceMock.saveDeathCertificateCommand(any())).thenReturn(deathCertificateCommandMock);
        assertEquals("redirect:/deathCertificate/0/show",
                deathCertificateFormController.saveOrUpdate(deathCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void showByIdTest() {
        assertEquals("certificates/deathCertificate/form",
                deathCertificateFormController.showById(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }


}