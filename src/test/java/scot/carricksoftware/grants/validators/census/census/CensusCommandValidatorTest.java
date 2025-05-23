/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CensusCommandValidatorTest {

    private CensusCommandValidator validator;

    @Mock
    private CensusCommandValidatorNumeric validatorNumericMock;

    @Mock
    private CensusCommandValidatorNonNumeric validatorNonNumericMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private CensusCommand censusCommandMock;

    @BeforeEach
    void setUp() {
        validator = new CensusCommandValidatorImpl(validatorNonNumericMock, validatorNumericMock);
    }

    @Test
    void nonNumericValidatorIsCalledTest() {
        validator.validate(censusCommandMock, bindingResultMock);
        verify(validatorNonNumericMock).validate(censusCommandMock, bindingResultMock);
    }

    @Test
    void numericValidatorIsCalledTest() {
        validator.validate(censusCommandMock, bindingResultMock);
        verify(validatorNumericMock).validate(censusCommandMock, bindingResultMock);
    }
}