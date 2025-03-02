/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.census.census.CensusConverter;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
public class CensusConverterTest {

    private CensusConverter converter;

    @Before
    public void setUp() {
        converter = new CensusConverterImpl();
    }

    @Test
    public void convertTest() {
        Census source = new Census();
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        Set<CensusEntry> censusEntries = new HashSet<>();
        censusEntries.add(GetRandomCensusEntry());

        source.setId(id);
        source.setPlace(place);
        source.setDate(date);
        source.setCensusEntries(censusEntries);

        CensusCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(place, target.getPlace());
        assertEquals(date, target.getDate());
        assertEquals(censusEntries, target.getCensusEntries());
    }
}