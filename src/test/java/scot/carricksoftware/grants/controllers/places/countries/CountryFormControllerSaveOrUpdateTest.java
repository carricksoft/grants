/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class CountryFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CountryFormControllerImpl countryController;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private CountryCommandConverterImpl countryCommandConverterMock;

    @Mock
    private CountryConverterImpl countryConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;


    @Mock
    BindingResult bindingResultMock;

    @Autowired
    private CountryCommand countryCommand;


    @BeforeEach
    void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        assertEquals("redirect:/country/4/show", countryController.saveOrUpdate(countryCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        assertEquals("country/form", countryController.saveOrUpdate(countryCommand, bindingResultMock));
    }

    @Test
    void CleaningTakesPlaceTest() {
        CountryCommand countryCommand = new CountryCommand();
        countryCommand.setId(4L);
        countryCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        countryController.saveOrUpdate(countryCommand, bindingResultMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}