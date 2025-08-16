/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates.CapitaliseMarriageCertificate;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.helpers.SetYearMarried;
import scot.carricksoftware.grants.validators.certificates.marriagecertificate.MarriageCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private MarriageCertificateFormControllerImpl marriageCertificateFormController;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @Mock
    private MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    private CapitaliseMarriageCertificate capitaliseMarriageCertificateMock;

    @Mock
    private SetYearMarried setYearMarriedMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private Model modelMock;

    @Mock
    private MarriageCertificateCommandValidator marriageCertificateCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        marriageCertificateFormController = new MarriageCertificateFormControllerImpl(marriageCertificateServiceMock,
                marriageCertificateCommandConverterMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandValidatorMock,
                capitaliseMarriageCertificateMock,
                setYearMarriedMock,
                addAttributesMock);
    }


    @Test
    public void marriageCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        when(marriageCertificateServiceMock.findById(id)).thenReturn(marriageCertificate);

        assertEquals("certificates/marriageCertificate/form", marriageCertificateFormController.marriageCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        MarriageCertificateCommand marriageCertificateCommand = GetRandomMarriageCertificateCommand();

        when(marriageCertificateServiceMock.findById(id)).thenReturn(marriageCertificate);
        when(marriageCertificateConverterMock.convert(marriageCertificate)).thenReturn(marriageCertificateCommand);
        assertEquals("certificates/marriageCertificate/form", marriageCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificateCommand);
    }

}