/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTextCommandValidatorImplTest {

    private PersonTextCommandValidatorImpl validator;

    @Mock
    ValidateTypes validateTypesMock;


    @BeforeEach
    void setUp() {
        validator = new PersonTextCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(validator);
    }
}