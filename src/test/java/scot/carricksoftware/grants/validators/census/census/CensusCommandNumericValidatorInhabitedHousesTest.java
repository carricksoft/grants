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
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grants.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class CensusCommandNumericValidatorInhabitedHousesTest {

    private CensusCommandValidatorNumeric validator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private CensusCommand censusCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusCommandValidatorNumericImpl();
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
    public void validateInhabitedHousesNegativeTest() {
        censusCommand.setInhabitedHouses("-5");
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("inhabitedHouses", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }


    @Test
    public void validateInhabitedHousesNonNumberTest() {
        censusCommand.setInhabitedHouses("z");
        validator.validate(censusCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor2.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor3.capture());
        assertEquals("inhabitedHouses", stringArgumentCaptor.getValue());
        assertEquals("", stringArgumentCaptor2.getValue());
        assertNull(objectArgumentCaptor.getValue());
        assertEquals("Not a non negative integer.", stringArgumentCaptor3.getValue());
    }

    @Test
    public void validateInhabitedHousesValidNumberTest() {
        censusCommand.setInhabitedHouses("5");
        validator.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateInhabitedHousesNullTest() {
        censusCommand.setInhabitedHouses(null);
        validator.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateInhabitedHousesZeroTest() {
        censusCommand.setInhabitedHouses("0");
        validator.validate(censusCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }
}
