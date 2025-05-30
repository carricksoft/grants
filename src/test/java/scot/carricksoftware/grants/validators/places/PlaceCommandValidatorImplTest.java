/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:41. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;

@ExtendWith(MockitoExtension.class)
class PlaceCommandValidatorImplTest {

    private PlaceCommandValidator validator;

    private PlaceCommand placeCommand;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new PlaceCommandValidator();
        placeCommand = new PlaceCommandImpl();
    }

    @Test
    public void minimumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH]).replace("\0", "x");
        placeCommand.setName(repeated);
        placeCommand.setRegion(GetRandomRegion());
        validator.validate(placeCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void maximumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH]).replace("\0", "x");
        placeCommand.setName(repeated);
        placeCommand.setRegion(GetRandomRegion());
        validator.validate(placeCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void greaterThanMaximumSizeIsRejectedTest() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object[]> objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH + 1]).replace("\0", "x");
        placeCommand.setName(repeated);
        placeCommand.setRegion(GetRandomRegion());
        validator.validate(placeCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor.capture());
        assertEquals("name", stringArgumentCaptor.getAllValues().get(0));
        assertEquals(ApplicationConstants.EMPTY_STRING, stringArgumentCaptor.getAllValues().get(1));
        assertEquals(ValidationConstants.NAME_IS_TOO_LONG, stringArgumentCaptor.getAllValues().get(2));
        assertNull(objectArgumentCaptor.getAllValues().get(0));
    }

    @Test
    public void smallerThanMinimumSizeIsRejectedTest() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object[]> objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH - 1]).replace("\0", "x");
        placeCommand.setName(repeated);
        placeCommand.setRegion(GetRandomRegion());
        validator.validate(placeCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor.capture());
        assertEquals("name", stringArgumentCaptor.getAllValues().get(0));
        assertEquals(ApplicationConstants.EMPTY_STRING, stringArgumentCaptor.getAllValues().get(1));
        assertEquals(ValidationConstants.NAME_IS_TOO_SHORT, stringArgumentCaptor.getAllValues().get(2));
        assertNull(objectArgumentCaptor.getAllValues().get(0));
    }

    @Test
    public void nullRegionTest() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object[]> objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);
        placeCommand.setRegion(null);
        placeCommand.setName(GetRandomString());
        validator.validate(placeCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor.capture());
        assertEquals("region", stringArgumentCaptor.getAllValues().get(0));
        assertEquals(ApplicationConstants.EMPTY_STRING, stringArgumentCaptor.getAllValues().get(1));
        assertEquals(ValidationConstants.REGION_IS_NULL, stringArgumentCaptor.getAllValues().get(2));
        assertNull(objectArgumentCaptor.getAllValues().get(0));
    }
}