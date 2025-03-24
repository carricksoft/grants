/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DeathCertificateConverterTest {

    private DeathCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        DeathCertificate source = new DeathCertificate();

        source.setId(id);

        DeathCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
    }
}