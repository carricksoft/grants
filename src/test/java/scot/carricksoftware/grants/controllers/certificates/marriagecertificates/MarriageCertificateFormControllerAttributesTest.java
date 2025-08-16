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
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates.CapitaliseMarriageCertificate;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.controllers.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.helpers.SetYearMarried;
import scot.carricksoftware.grants.validators.certificates.marriagecertificate.MarriageCertificateCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateFormControllerAttributesTest {

    @SuppressWarnings("unused")
    private MarriageCertificateFormControllerImpl marriageCertificateFormController;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @Mock
    private MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private CapitaliseMarriageCertificate capitaliseMarriageCertificateMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private MarriageCertificateCommandValidatorImpl marriageCertificateCommandValidatorImplMock;

    @Mock
    private MarriageCertificateCommand marriageCertificateCommandMock;

    @Mock
    private SetYearMarried setYearMarriedMock;

    @Mock
    private BindingResult bindingResultMock;


    @BeforeEach
    public void setUp() {
        marriageCertificateFormController = new MarriageCertificateFormControllerImpl(marriageCertificateServiceMock,
                marriageCertificateCommandConverterMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandValidatorImplMock,
                capitaliseMarriageCertificateMock,
                setYearMarriedMock,
                addAttributesMock);
    }

    @Test
    public void newCertificateTest() {
        assertEquals("certificates/marriageCertificate/form",marriageCertificateFormController.getNewMarriageCertificate(modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void editCertificateTest() {
        assertEquals("certificates/marriageCertificate/form",marriageCertificateFormController.marriageCertificateEdit(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/marriageCertificate/form",
                marriageCertificateFormController.saveOrUpdate(marriageCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(marriageCertificateServiceMock.saveMarriageCertificateCommand(any())).thenReturn(marriageCertificateCommandMock);
        assertEquals("redirect:/marriageCertificate/0/show",
                marriageCertificateFormController.saveOrUpdate(marriageCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void showByIdTest() {
        assertEquals("certificates/marriageCertificate/form",
                marriageCertificateFormController.showById(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }


}