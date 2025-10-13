/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class ValidateTypesFileTest {

    private ValidateTypes validateTypes;

    private String field;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        field = "field";
        message = "message";
    }

    @Test
    void allowedTypeTest() {
        validateTypes.validateFileType("file.YES", field, new String[]{"YES"}, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void lowerCaseAllowedTypeTest() {
        validateTypes.validateFileType("file.yes", field, new String[]{"YES"}, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void notAllowedTypeTest() {
        validateTypes.validateFileType("file.YES", field, new String[]{"NON"}, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, message);
    }

}