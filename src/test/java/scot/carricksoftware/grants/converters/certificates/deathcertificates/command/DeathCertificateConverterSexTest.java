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
import scot.carricksoftware.grants.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeathCertificateConverterSexTest {

    private DeathCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateConverterImpl();
    }

    @Test
    void convertTest() {

        Sex sex = Sex.MALE;

        DeathCertificate source = new DeathCertificate();

        source.setSex(sex);

        DeathCertificateCommand target = converter.convert(source);

        assert target != null;

        assertEquals(sex,target.getSex());

        
    }
}