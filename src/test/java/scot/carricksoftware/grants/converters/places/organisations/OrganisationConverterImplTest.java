/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.organisations;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@Component
public class OrganisationConverterImplTest {

    final OrganisationConverterImpl converter = new OrganisationConverterImpl();
    Organisation source;

    @BeforeEach
    public void setUp() {
        source = new Organisation();
    }

    @Test
    public void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();

        source.setId(id);
        source.setName(name);

        OrganisationCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
    }

}