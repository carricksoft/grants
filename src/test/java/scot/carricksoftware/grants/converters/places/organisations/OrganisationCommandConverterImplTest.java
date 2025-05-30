/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.organisations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.domains.places.Organisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


public class OrganisationCommandConverterImplTest {

    final OrganisationCommandConverterImpl converter = new OrganisationCommandConverterImpl();
    OrganisationCommand source;

    @BeforeEach
    public void setUp() {
        source = new OrganisationCommandImpl();
    }

    @Test
    public void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();

        source.setId(id);
        source.setName(name);

        Organisation target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
    }
}