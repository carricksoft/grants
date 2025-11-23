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
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class DocumentTextCommandValidatorImplTest {

    private DocumentTextCommandValidatorImpl validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    private DocumentTextCommand documentTextCommand;

    @BeforeEach
    void setUp() {
        validator = new DocumentTextCommandValidatorImpl(validateTypesMock);
        documentTextCommand = new DocumentTextCommandImpl();
    }

    @Test
    void validateRangeIsCalledTest() {
        String order = GetRandomString();
        documentTextCommand.setOrder(order);
        validator.validate(documentTextCommand, bindingResultMock);
        verify(validateTypesMock).validateNonNegativeInteger(order,
                "order",
                "Order must exist.",
                "The order must be an integer.",
                "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsCalledTest() {
        String level = GetRandomString();
        documentTextCommand.setLevel(level);
        validator.validate(documentTextCommand, bindingResultMock);
        verify(validateTypesMock).validateIntegerStaredRange(level,
                -2,
                5,
                "level",
                "Level must exist.",
                "Level must be an integer.",
                "Level must be between -2 and 5.", bindingResultMock);
    }


}