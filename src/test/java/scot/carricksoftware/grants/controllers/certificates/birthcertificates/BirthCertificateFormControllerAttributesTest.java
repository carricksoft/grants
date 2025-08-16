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
import scot.carricksoftware.grants.controllers.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.birthcertificates.UpdateCertifiedYearOfBirth;
import scot.carricksoftware.grants.validators.certificates.birthcertificate.BirthCertificateCommandValidatorImpl;

import static org.mockito.Mockito.verify;



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
    public void newCertificateTest() {
        birthCertificateFormController.getNewBirthCertificate(modelMock);
        verify(addAttributesMock).AddBMDCertificate(modelMock);
    }



}