/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitaliseCountryTest {

    private CapitaliseCountry capitaliseCountry;

    @Mock
    private CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitaliseCountry = new CapitaliseCountryImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseNameTest() {
        CountryCommand countryCommand = new CountryCommandImpl();
        countryCommand.setName("lower");
        when(capitaliseStringMock.capitalise("lower")).thenReturn("Lower");
        capitaliseCountry.capitalise(countryCommand);
        assertEquals("Lower", countryCommand.getName());
    }
}