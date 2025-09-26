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
import scot.carricksoftware.grants.capitalisation.certificates.birthcertificates.CapitaliseBirthCertificate;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.birthcertificates.UpdateCertifiedYearOfBirth;
import scot.carricksoftware.grants.validators.certificates.birthcertificate.BirthCertificateCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificateCommand;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateFormControllerTest {

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
    private CapitaliseBirthCertificate capitaliseBirthCertificateMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private BirthCertificateCommandValidatorImpl birthCertificateCommandValidatorImplMock;

    @Mock
    private UpdateCertifiedYearOfBirth updateCertifiedYearOfBirthMock;


    @BeforeEach
    public void setUp() {
        birthCertificateFormController = new BirthCertificateFormControllerImpl(birthCertificateServiceMock,
                birthCertificateCommandConverterMock,
                birthCertificateConverterMock,
                birthCertificateCommandValidatorImplMock,
                capitaliseBirthCertificateMock,
                updateCertifiedYearOfBirthMock,
                addAttributesMock);
    }


    @Test
    public void birthCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        when(birthCertificateServiceMock.findById(id)).thenReturn(birthCertificate);

        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.birthCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, birthCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        BirthCertificateCommand birthCertificateCommand = GetRandomBirthCertificateCommand();

        when(birthCertificateServiceMock.findById(id)).thenReturn(birthCertificate);
        when(birthCertificateConverterMock.convert(birthCertificate)).thenReturn(birthCertificateCommand);
        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, birthCertificateCommand);
    }


}