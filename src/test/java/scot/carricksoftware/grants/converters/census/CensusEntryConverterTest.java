/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class CensusEntryConverterTest {

    private CensusEntryConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusEntryConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        CensusEntry source = new CensusEntry();
        source.setId(id);
        source.setName(name);

        CensusEntryCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
    }
}