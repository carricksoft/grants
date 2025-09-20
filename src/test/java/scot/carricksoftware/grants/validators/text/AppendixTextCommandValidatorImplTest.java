/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class AppendixTextCommandValidatorImplTest {

    private AppendixTextCommandValidatorImpl validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    private AppendixTextCommand appendixTextCommand;

    @BeforeEach
    void setUp() {
        validator = new AppendixTextCommandValidatorImpl(validateTypesMock);
        appendixTextCommand = new AppendixTextCommandImpl();
    }

    @Test
    void validateRangeIsCalledTest() {
        String order = GetRandomString();
        appendixTextCommand.setOrder(order);
       validator.validate(appendixTextCommand, bindingResultMock);
       verify(validateTypesMock).validateNonNegativeInteger(order,
               "order",
               "Order must exist.",
               "The order must be an integer.",
               "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsCalledTest() {
        String level = GetRandomString();
        appendixTextCommand.setLevel(level);
        validator.validate(appendixTextCommand, bindingResultMock);
        verify(validateTypesMock).validateIntegerRange(level,
                -2,
                5,
                "level",
                "Level must exist.",
                "Level must be an integer.",
                "Level must be between -2 and 5.", bindingResultMock);
    }


}