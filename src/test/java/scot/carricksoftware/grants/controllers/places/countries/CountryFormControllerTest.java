/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.places.CountryFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.CountryService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountryCommand;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class CountryFormControllerTest {

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
    private Model modelMock;


    @BeforeEach
    void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock);
    }

    @Test
    void getNewCountryTest() {
        Model model = new ExtendedModelMap();
        assertEquals("country/form", countryController.getNewCountry(model));
        assertEquals(CountryCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.COUNTRY_COMMAND)).getClass());
    }

    @Test
    void countryEditTestEditTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        when(countryServiceMock.findById(id)).thenReturn(country);

        assertEquals("country/form", countryController.countryEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.COUNTRY_COMMAND, country);
    }

    @Test
    void showByIdTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        CountryCommand countryCommand = GetRandomCountryCommand();

        when(countryServiceMock.findById(id)).thenReturn(country);
        when(countryConverterMock.convert(country)).thenReturn(countryCommand);
        assertEquals("country/form", countryController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.COUNTRY_COMMAND, countryCommand);
    }

}