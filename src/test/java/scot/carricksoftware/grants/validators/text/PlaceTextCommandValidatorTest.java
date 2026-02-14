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
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class PlaceTextCommandValidatorTest {

    private PlaceTextCommandValidatorImpl validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    private PlaceTextCommand placeTextCommand;

    @BeforeEach
    void setUp() {
        validator = new PlaceTextCommandValidatorImpl(validateTypesMock);
        placeTextCommand = new PlaceTextCommandImpl();
    }

    @Test
    void validateRangeIsCalledTest() {
        String order = GetRandomString();
        placeTextCommand.setOrder(order);
        validator.validate(placeTextCommand, bindingResultMock);
        verify(validateTypesMock).validateNonNegativeInteger(order,
                "order",
                "Order must exist.",
                "The order must be an integer.",
                "The order must be non-negative.", bindingResultMock);
    }



    @Test
    void validateLevelIsCalledTest() {
        String level = GetRandomString();
        placeTextCommand.setLevel(level);
        validator.validate(placeTextCommand, bindingResultMock);
        verify(validateTypesMock).validateIntegerAsteriskRange(level,
                -2,
                5,
                "level",
                "Level must exist.",
                "Level must be an integer.",
                "Level must be between -2 and 5.", bindingResultMock);
    }


    @Test
    void validatePlaceIsCalledTest() {
        Place place =  GetRandomPlace();
        placeTextCommand.setPlace(place);
        validator.validate(placeTextCommand, bindingResultMock);
        verify(validateTypesMock).validatePlace(place, "place",  "Place must exist.", bindingResultMock);

    }
}