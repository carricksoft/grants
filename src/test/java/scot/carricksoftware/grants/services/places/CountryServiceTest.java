/*
 * Copyright (c)  05 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class CountryServiceTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @BeforeEach
    void setUp() {
        countryService = new CountryServiceImpl(countryRepositoryMock);
    }


    @Test
    void findAllTest() {
        HashSet<Country> countries = new HashSet<>();
        Country scotland = new Country();
        countries.add(scotland);
        when(countryRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, countryService.findAll());
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        assertTrue(true);
    }


    @Test
    void saveTest() {
        Country scotland = new Country();
        scotland.setName("Scotland");

        when(countryRepositoryMock.save(scotland)).thenReturn(scotland);

        assertEquals(scotland, countryService.save(scotland));
    }
}