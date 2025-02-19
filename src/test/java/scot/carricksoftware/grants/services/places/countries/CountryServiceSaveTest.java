/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.CountryCommand;
import scot.carricksoftware.grants.converters.places.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class CountryServiceSaveTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterImplMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        countryService = new CountryServiceImpl(countryRepositoryMock,
                countryConverterImplMock,
                countryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        Country country = new Country();
        country.setName(GetRandomString());

        when(countryRepositoryMock.save(country)).thenReturn(country);

        assertEquals(country, countryService.save(country));
    }

    @Test
    void saveCountryCommandTest() {
        Country country = GetRandomCountry();
        CountryCommand countryCommand = new CountryCommand();
        when(countryCommandConverterImplMock.convert(countryCommand)).thenReturn(country);
        when(countryRepositoryMock.save(country)).thenReturn(country);
        when(countryConverterImplMock.convert((country))).thenReturn(countryCommand);

        assertEquals(countryCommand, countryService.saveCountryCommand(countryCommand));
    }


}