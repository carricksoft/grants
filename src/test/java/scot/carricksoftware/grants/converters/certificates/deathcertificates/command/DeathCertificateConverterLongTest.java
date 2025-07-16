/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverter;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DeathCertificateConverterLongTest {

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
        assertEquals(id,target.getId());


    }
}