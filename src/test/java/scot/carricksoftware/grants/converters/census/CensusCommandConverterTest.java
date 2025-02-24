/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
class CensusCommandConverterTest {

    private CensusCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusCommandConverterImpl();
    }

    @Test
    void convertTest() {
        CensusCommand source = new CensusCommand();
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);

        source.setId(id);
        source.setPlace(place);
        source.setDate(date);

        Census target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(place, target.getPlace());
        assertEquals(date, target.getDate());
    }
}