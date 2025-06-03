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
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartTwoValidatorTest {

    private BirthCertificateCommandPartTwoValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartTwoValidatorImpl(validateTypesMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(validator);
    }

}