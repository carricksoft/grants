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
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;

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
    void nullPersonCommandTest() {
        assertThrows(NullPointerException.class, () -> updateCertifiedYearOfBirth.updateCertifiedYearOfBirth(null));
    }
}