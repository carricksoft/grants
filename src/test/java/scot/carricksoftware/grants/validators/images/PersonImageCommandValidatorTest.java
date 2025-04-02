/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 14:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonImageCommandValidatorTest {

    private PersonImageCommandValidator validator;

    private PersonImageCommand personImageCommand;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new PersonImageCommandValidator();
        personImageCommand = new PersonImageCommandImpl();

        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);
    }

    @Test
    void validateNullPerson() {
        validator.validate(personImageCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("person", stringArgumentCaptor.getValue());
        assertEquals("The person cannot be null.", stringArgumentCaptor3.getValue());
    }
}