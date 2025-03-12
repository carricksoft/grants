/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverter;
import scot.carricksoftware.grants.converters.places.countries.CountryConverter;
import scot.carricksoftware.grants.services.places.countries.CountryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class CountryFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CountryFormControllerImpl countryController;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private CountryCommandConverter countryCommandConverterMock;

    @Mock
    private CountryConverter countryConverterMock;

    @Mock
    private Capitalisation capitalisationMock;


    @Mock
    BindingResult bindingResultMock;

    private CountryCommand countryCommand;


    @BeforeEach
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock);
        countryCommand = new CountryCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        assertEquals("redirect:/country/4/show", countryController.saveOrUpdate(countryCommand, bindingResultMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("country/form", countryController.saveOrUpdate(countryCommand, bindingResultMock));
    }

    @Test
    public void CleaningTakesPlaceTest() {
        CountryCommand countryCommand = new CountryCommandImpl();
        countryCommand.setId(4L);
        countryCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        countryController.saveOrUpdate(countryCommand, bindingResultMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}