/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images.placeimage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
class PlaceImageCommandValidatorTest {

    private PlaceImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private PlaceImageCommand placeImageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new PlaceImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validatePlaceIsRunTest() {
        Place place = GetRandomPlace();
        when(placeImageCommandMock.getPlace()).thenReturn(place);
        validator.validate(placeImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validatePlace(place,
                "place", "Place must exist.", bindingResultMock);
    }

    @Test
    void validateImageIsRunTest() {
        Image image = new Image();
        when(placeImageCommandMock.getImage()).thenReturn(image);
        validator.validate(placeImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateImage(image,
                "image", "The image cannot be null.", bindingResultMock);
    }

    @Test
    void validateOrderIsRunTest() {
        String order = GetRandomString();
        when(placeImageCommandMock.getOrder()).thenReturn(order);
        validator.validate(placeImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNonNegativeInteger(order,
                "order", "Order must exist.", "The order must be an integer.",
                "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsCalledTest() {
        String level = GetRandomString();
        when(placeImageCommandMock.getLevel()).thenReturn(level);
        validator.validate(placeImageCommandMock, bindingResultMock);
        verify(validateTypesMock).validateIntegerAsteriskRange(level,
                -2,
                5,
                "level",
                "Level must exist.",
                "Level must be an integer.",
                "Level must be between -2 and 5.", bindingResultMock);
    }


}