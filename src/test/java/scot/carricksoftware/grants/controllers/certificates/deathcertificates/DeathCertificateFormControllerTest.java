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
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificates.CapitaliseDeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.UpdateCertifiedYearOfDeath;
import scot.carricksoftware.grants.validators.certificates.deathcertificate.DeathCertificateCommandValidator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private DeathCertificateFormController deathCertificateFormController;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private DeathCertificateCommandConverterImpl deathCertificateCommandConverterMock;

    @Mock
    private DeathCertificateConverterImpl deathCertificateConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private DeathCertificateCommandValidator deathCertificateCommandValidatorMock;

    @Mock
    CapitaliseDeathCertificateCommand capitaliseDeathCertificateCommandMock;

    @Mock
    private UpdateCertifiedYearOfDeath updateCertifiedYearOfDeathMock;

    @Mock
    private AddAttributes addAttributesMock;


    @BeforeEach
    public void setUp() {
        deathCertificateFormController = new DeathCertificateFormControllerImpl(deathCertificateServiceMock,
                deathCertificateCommandConverterMock,
                deathCertificateConverterMock,
                deathCertificateCommandValidatorMock,
                capitaliseDeathCertificateCommandMock,
                updateCertifiedYearOfDeathMock,
                addAttributesMock);
    }


    @Test
    public void deathCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        when(deathCertificateServiceMock.findById(id)).thenReturn(deathCertificate);

        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.deathCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, deathCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        DeathCertificateCommand deathCertificateCommand = GetRandomDeathCertificateCommand();

        when(deathCertificateServiceMock.findById(id)).thenReturn(deathCertificate);
        when(deathCertificateConverterMock.convert(deathCertificate)).thenReturn(deathCertificateCommand);
        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, deathCertificateCommand);
    }

}