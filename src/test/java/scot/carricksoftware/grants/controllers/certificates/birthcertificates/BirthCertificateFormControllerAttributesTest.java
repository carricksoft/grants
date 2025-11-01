/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.certificates.birthcertificate.CapitaliseBirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.birthcertificates.UpdateCertifiedYearOfBirth;
import scot.carricksoftware.grants.validators.certificates.birthcertificate.BirthCertificateCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateFormControllerAttributesTest {

    @SuppressWarnings("unused")
    private BirthCertificateFormControllerImpl birthCertificateFormController;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private BirthCertificateCommandConverterImpl birthCertificateCommandConverterMock;

    @Mock
    private BirthCertificateConverterImpl birthCertificateConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private CapitaliseBirthCertificateCommand capitaliseBirthCertificateCommandMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private BirthCertificateCommandValidatorImpl birthCertificateCommandValidatorImplMock;

    @Mock
    private UpdateCertifiedYearOfBirth updateCertifiedYearOfBirthMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;


    @BeforeEach
    public void setUp() {
        birthCertificateFormController = new BirthCertificateFormControllerImpl(birthCertificateServiceMock,
                birthCertificateCommandConverterMock,
                birthCertificateConverterMock,
                birthCertificateCommandValidatorImplMock,
                capitaliseBirthCertificateCommandMock,
                updateCertifiedYearOfBirthMock,
                addAttributesMock);
    }

    @Test
    public void newCertificateTest() {
        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.getNewBirthCertificate(modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void editCertificateTest() {
        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.birthCertificateEdit(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/birthCertificate/form",
                birthCertificateFormController.saveOrUpdate(birthCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(birthCertificateServiceMock.saveBirthCertificateCommand(any())).thenReturn(birthCertificateCommandMock);
        assertEquals("redirect:/birthCertificate/0/show",
                birthCertificateFormController.saveOrUpdate(birthCertificateCommandMock, bindingResultMock, modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }

    @Test
    public void showByIdTest() {
        assertEquals("certificates/birthCertificate/form",
                birthCertificateFormController.showById(GetRandomLong().toString(), modelMock));
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }


}