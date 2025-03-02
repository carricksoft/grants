/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryFormControllerCleansingTest {

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
    CountryCommand countryCommandMock;

    @Mock
    BindingResult bindingResultMock;


    @Before
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(countryServiceMock.saveCountryCommand(any())).thenReturn(countryCommandMock);
        when(countryCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        countryController.saveOrUpdate(countryCommandMock, bindingResultMock);
        verify(countryCommandMock).setName(uName);
    }


}