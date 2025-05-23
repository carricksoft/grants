/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.census.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class CensusCommandNonNumericCoexistenceTest {

    private CensusCommandValidatorNonNumeric validator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private CensusCommand censusCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusCommandValidatorNonNumericImpl();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        censusCommand = new CensusCommandImpl();
        censusCommand.setInhabitedRooms("1");
        censusCommand.setRoomsWithWindows("1");
    }

    @Test
    public void testTotalRoomsAndInhabitedRoomsTest() {
        censusCommand.setTotalRooms("1");
        censusCommand.setInhabitedRooms("1");
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setBoundaryType(GetRandomCensusBoundaryType());
        censusCommand.setCensusDate(GetRandomCensusDate());
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        boolean foundInhabitedRooms = false;
        boolean foundTotalRooms = false;
        for (int i = 0; i < stringArgumentCaptor.getAllValues().size(); i++) {
            if (stringArgumentCaptor.getAllValues().get(i).equals("inhabitedRooms")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("Total Rooms and Inhabited Rooms cannot coexist.")) {
                    foundInhabitedRooms = true;
                }
            }
            if (stringArgumentCaptor.getAllValues().get(i).equals("totalRooms")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("Total Rooms and Inhabited Rooms cannot coexist.")) {
                    foundTotalRooms = true;
                }
            }
        }
        assertTrue(foundInhabitedRooms && foundTotalRooms);
    }

    @Test
    public void testTotalRoomsAndRoomsWithWindowsTest() {
        censusCommand.setTotalRooms("1");
        censusCommand.setRoomsWithWindows("1");
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setBoundaryType(GetRandomCensusBoundaryType());
        censusCommand.setCensusDate(GetRandomCensusDate());
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        boolean foundRoomsWithWindows = false;
        boolean foundTotalRooms = false;
        for (int i = 0; i < stringArgumentCaptor.getAllValues().size(); i++) {
            if (stringArgumentCaptor.getAllValues().get(i).equals("roomsWithWindows")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("Total Rooms and Rooms With Windows cannot coexist.")) {
                    foundRoomsWithWindows = true;
                }
            }
            if (stringArgumentCaptor.getAllValues().get(i).equals("totalRooms")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("Total Rooms and Rooms With Windows cannot coexist.")) {
                    foundTotalRooms = true;
                }
            }
        }
        assertTrue(foundRoomsWithWindows && foundTotalRooms);
    }
}
