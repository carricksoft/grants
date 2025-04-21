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
class CensusCommandValidatorRoomsInhabitedTest {

    private CensusCommandValidator censusCommandValidator = new CensusCommandValidator();

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private CensusCommand censusCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        censusCommandValidator = new CensusCommandValidator();
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
    public void validateRoomsInhabitedNegativeTest() {
        censusCommand.setInhabitedRooms("-1");
        censusCommand.setRoomsWithWindows("5");
       censusCommandValidator.validate(censusCommand, bindingResultMock);
       verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(),stringArgumentCaptor3.capture());
       assertEquals("roomsInhabited", stringArgumentCaptor.getValue());
       assertEquals("", stringArgumentCaptor2.getValue());
       assertNull(objectArgumentCaptor.getValue());
       assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
   }


    @Test
    public void validateRoomsInhabitedNonNumberTest() {
        censusCommand.setInhabitedRooms("z");
        censusCommand.setRoomsWithWindows("5");
        censusCommandValidator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(),stringArgumentCaptor3.capture());
        assertEquals("roomsInhabited", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void validateRoomsInhabitedValidNumberTest() {
        censusCommand.setInhabitedRooms("3");
        censusCommand.setRoomsWithWindows("5");
        censusCommandValidator.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

}