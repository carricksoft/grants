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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class CensusCommandNonNumericValidatorTest {

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
    public void nullDateTest() {
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setBoundaryType(GetRandomCensusBoundaryType());
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("date", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Date must exist.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void nullBoundaryTest() {
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setCensusDate(GetRandomCensusDate());
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("boundaryType", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("The boundary type cannot be null.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void nullPlaceTest() {
        censusCommand.setCensusDate(GetRandomCensusDate());
        censusCommand.setBoundaryType(GetRandomCensusBoundaryType());
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("place", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("The place cannot be null.", stringArgumentCaptor3.getValue());
    }
}
