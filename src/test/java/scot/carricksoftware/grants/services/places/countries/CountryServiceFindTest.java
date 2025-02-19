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
import scot.carricksoftware.grants.converters.places.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
class CountryServiceFindTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterImplMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterImplMock;

    @BeforeEach
    void setUp() {
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
    void findByIdTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        when(countryRepositoryMock.findById(id)).thenReturn(Optional.of(country));
        assertEquals(country, countryService.findById(id));
    }

    @Test
    void findByIdNullTest() {
        Long id = GetRandomLong();
        when(countryRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(countryService.findById(id));
    }

}