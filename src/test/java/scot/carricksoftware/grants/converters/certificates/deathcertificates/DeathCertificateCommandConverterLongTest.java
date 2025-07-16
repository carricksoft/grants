/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DeathCertificateCommandConverterLongTest {

    private DeathCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();

        DeathCertificateCommand source = new DeathCertificateCommandImpl();

        source.setId(id);

        DeathCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(id,target.getId());


    }
}