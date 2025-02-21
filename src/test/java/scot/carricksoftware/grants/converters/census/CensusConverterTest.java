/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
class CensusConverterTest {

    private CensusConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusConverterImpl();
    }

    @Test
    void convertTest() {
        Census source = new Census();
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        LocalDate date = LocalDate.now();

        source.setId(id);
        source.setPlace(place);
        source.setDate(date);

        CensusCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id,target.getId());
        assertEquals(place,target.getPlace());
        assertEquals(date,target.getDate());
    }
}