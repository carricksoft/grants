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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class CensusCommandValidatorTotalRoomsTest {

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
    public void validateTotalNegativeTest() {
        censusCommand.setTotalRooms("-1");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("totalRooms", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void validateTotalNonNumberTest() {
        censusCommand.setTotalRooms("z");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("totalRooms", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void validateTotalRoomsValidNumberTest() {
        censusCommand.setTotalRooms("3");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateTotalRoomsAndInhabitedRoomsTest() {
        censusCommand.setTotalRooms("3");
        censusCommand.setInhabitedRooms("3");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());

        assertTrue(stringArgumentCaptor.getAllValues().contains("totalRooms"));
        assertTrue(stringArgumentCaptor.getAllValues().contains("inhabitedRooms"));
    }

    @Test
    public void validateTotalRoomsAndRoomsWithWindowsTest() {
        censusCommand.setTotalRooms("3");
        censusCommand.setRoomsWithWindows("3");
        censusCommandValidatorImpl.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());

        assertTrue(stringArgumentCaptor.getAllValues().contains("totalRooms"));
        assertTrue(stringArgumentCaptor.getAllValues().contains("roomsWithWindows"));
    }



}