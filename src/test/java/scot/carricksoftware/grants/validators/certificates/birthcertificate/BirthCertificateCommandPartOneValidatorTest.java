/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartOneValidatorTest {

    private BirthCertificateCommandPartOneValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartOneValidatorImpl(validateTypesMock);
    }

    @Test
    void validateNewBornTest() {
        when(birthCertificateCommandMock.getNewBorn()).thenReturn(new Person());
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePerson(birthCertificateCommandMock.getNewBorn(), "newBorn", "The New Born cannot be null.", bindingResultMock);
    }
}