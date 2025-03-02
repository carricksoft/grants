/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.countries;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
public class CountryServiceFindTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterImplMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterImplMock;

    @Before
    public void setUp() {
        countryService = new CountryServiceImpl(
                countryRepositoryMock,
                countryConverterImplMock,
                countryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void findByIdTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        when(countryRepositoryMock.findById(id)).thenReturn(Optional.of(country));
        assertEquals(country, countryService.findById(id));
    }

    @Test
    public void findByIdNullTest() {
        Long id = GetRandomLong();
        when(countryRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(countryService.findById(id));
    }

    @Test
    public void findAllTest() {
        List<Country> testList = new ArrayList<>();
        Country testCountry = new Country();
        testList.add(testCountry);
        when(countryRepositoryMock.findAll())
                .thenReturn(testList);
        assertEquals(testList, countryService.findAll());
        verify(countryRepositoryMock).findAll();
    }

}