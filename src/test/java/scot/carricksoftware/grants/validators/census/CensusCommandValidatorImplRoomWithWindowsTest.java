/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class CensusCommandValidatorImplRoomWithWindowsTest {

    private CensusCommandValidatorImpl censusCommandValidatorImpl = new CensusCommandValidatorImpl();

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private CensusCommand censusCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        censusCommandValidatorImpl = new CensusCommandValidatorImpl();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        censusCommand = new CensusCommandImpl();
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setCensusDate(GetRandomCensusDate());
        censusCommand.setBoundaryType(GetRandomCensusBoundaryType());
    }

    @Test
    public void validateRoomsWithWindowsNegativeTest() {
        censusCommand.setInhabitedRooms("1");
        censusCommand.setRoomsWithWindows("-5");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("roomsWithWindows", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }


    @Test
    public void validateRoomsWithWindowsNonNumberTest() {
        censusCommand.setInhabitedRooms("1");
        censusCommand.setRoomsWithWindows("z");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("roomsWithWindows", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void validateRoomsWithWindowsValidNumberTest() {
        censusCommand.setInhabitedRooms("3");
        censusCommand.setRoomsWithWindows("5");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateRoomsWithWindowsNullTest() {
        censusCommand.setInhabitedRooms("3");
        censusCommand.setRoomsWithWindows(null);
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateRoomsWithWindowsZeroTest() {
        censusCommand.setInhabitedRooms("3");
        censusCommand.setRoomsWithWindows("0");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

}