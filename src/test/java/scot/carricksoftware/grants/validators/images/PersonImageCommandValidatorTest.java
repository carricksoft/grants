/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 14:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


@ExtendWith(MockitoExtension.class)
class PersonImageCommandValidatorTest {

    private PersonImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private PersonImageCommand personImageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new PersonImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validatePersonIsRunTest() {
        Person person = GetRandomPerson();
        when(personImageCommandMock.getPerson()).thenReturn(person);
        validator.validate(personImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validatePerson(person,
                "person", "The person cannot be null.", bindingResultMock);
    }

    @Test
    void validateImageIsRunTest() {
        Image image = new Image();
        when(personImageCommandMock.getImage()).thenReturn(image);
        validator.validate(personImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateImage(image,
                "image", "The image cannot be null.", bindingResultMock);
    }



}