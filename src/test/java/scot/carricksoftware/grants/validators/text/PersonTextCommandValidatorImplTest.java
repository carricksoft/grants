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
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class PersonTextCommandValidatorImplTest {

    private PersonTextCommandValidatorImpl validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    private PersonTextCommand personTextCommand;

    @BeforeEach
    void setUp() {
        validator = new PersonTextCommandValidatorImpl(validateTypesMock);
        personTextCommand = new PersonTextCommandImpl();
    }

    @Test
    void validateRangeIsCalledTest() {
        String order = GetRandomString();
        personTextCommand.setOrder(order);
       validator.validate(personTextCommand, bindingResultMock);
       verify(validateTypesMock).validateNonNegativeInteger(order,
               "order",
               "Order must exist.",
               "The order must be an integer.",
               "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsCalledTest() {
        String level = GetRandomString();
        personTextCommand.setLevel(level);
        validator.validate(personTextCommand, bindingResultMock);
        verify(validateTypesMock).validateIntegerRange(level,
                -2,
                5,
                "level",
                "Level must exist.",
                "Level must be an integer.",
                "Level must be between -2 and 5.", bindingResultMock);
    }

    @Test
    void validatePersonIsCalledTest() {
        Person person  = GetRandomPerson();
        personTextCommand.setPerson(person);
        validator.validate(personTextCommand, bindingResultMock);
        verify(validateTypesMock).validatePerson(person,
                "person",
                "The person cannot be null.",
                bindingResultMock);
    }

}