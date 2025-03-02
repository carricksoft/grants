/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.countries;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;

@SpringBootTest
public class CountryServiceTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterImplMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterImplMock;


    @Before
    public void setUp() {
        countryService = new CountryServiceImpl(countryRepositoryMock,
                countryConverterImplMock,
                countryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Country> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        countryService.deleteById(id);
        verify(countryRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(countryRepositoryMock.count()).thenReturn(result);
        assertEquals(result, countryService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Country> result = new ArrayList<>();
        Country country = GetRandomCountry();
        result.add(country);
        when(pageMock.getContent()).thenReturn(result);
        when(countryRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, countryService.getPagedCountries(0));
    }


}