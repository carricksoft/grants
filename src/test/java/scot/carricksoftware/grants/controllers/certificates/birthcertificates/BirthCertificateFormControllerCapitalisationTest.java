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
import scot.carricksoftware.grants.capitalisation.certificates.birthcertificates.CapitaliseBirthCertificate;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.controllers.attributes.AddAttributes;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.birthcertificates.UpdateCertifiedYearOfBirth;
import scot.carricksoftware.grants.validators.certificates.birthcertificate.BirthCertificateCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateFormControllerCapitalisationTest {

    @SuppressWarnings("unused")
    private BirthCertificateFormControllerImpl birthCertificateController;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private BirthCertificateCommandConverterImpl birthCertificateCommandConverterMock;

    @Mock
    private BirthCertificateConverterImpl birthCertificateConverterMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private CapitaliseBirthCertificate capitaliseBirthCertificateMock;

    @Mock
    private BirthCertificateCommandValidatorImpl birthCertificateCommandValidatorImplMock;

    @Mock
    private AddAttributes addAttributesMock;

    @Mock
    private UpdateCertifiedYearOfBirth updateCertifiedYearOfBirthMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    public void setUp() {
        birthCertificateController = new BirthCertificateFormControllerImpl(birthCertificateServiceMock,
                birthCertificateCommandConverterMock,
                birthCertificateConverterMock,
                birthCertificateCommandValidatorImplMock,
                capitaliseBirthCertificateMock,
                updateCertifiedYearOfBirthMock,
                addAttributesMock);
    }


    @Test
    public void saveOrUpdateCapitalisationTest() {
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();
        birthCertificateCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(birthCertificateServiceMock.saveBirthCertificateCommand(birthCertificateCommand)).thenReturn(birthCertificateCommand);

        birthCertificateController.saveOrUpdate(birthCertificateCommand, bindingResultMock, modelMock);

        verify(capitaliseBirthCertificateMock).capitalise(birthCertificateCommand);
    }


}