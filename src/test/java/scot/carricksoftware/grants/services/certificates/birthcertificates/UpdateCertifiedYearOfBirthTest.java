/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(OutputCaptureExtension.class)
@ExtendWith(MockitoExtension.class)
class UpdateCertifiedYearOfBirthTest {

    private UpdateCertifiedYearOfBirth updateCertifiedYearOfBirth;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonConverter personConverterMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;


    @BeforeEach
    void setUp() {
        updateCertifiedYearOfBirth = new UpdateCertifiedYearOfBirthImpl(personConverterMock, personServiceMock);
    }

    @Test
    void nullPersonTest() {
        updateCertifiedYearOfBirth.updateCertifiedYearOfBirth(birthCertificateCommandMock);
        verifyNoInteractions(personConverterMock);
    }

    @Test()
    void nullPersonCommandTest(CapturedOutput capturedOutput) {

        when(birthCertificateCommandMock.getNewBorn()).thenReturn(new Person());
        when(birthCertificateCommandMock.getWhenBorn()).thenReturn("25/01/1953 01:01)");
        when(personConverterMock.convert(any())).thenReturn(null);

        updateCertifiedYearOfBirth.updateCertifiedYearOfBirth(birthCertificateCommandMock);

        assertTrue(capturedOutput.getOut().contains("PersonCommand = null."));
    }

}