/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class BirthCertificateCommandConverterTest {

    private BirthCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new BirthCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        BirthCertificateCommand source = new BirthCertificateCommandImpl();

        source.setId(id);


        BirthCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
    }
}