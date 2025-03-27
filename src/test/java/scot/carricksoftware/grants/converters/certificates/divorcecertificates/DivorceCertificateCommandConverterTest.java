/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.divorcecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DivorceCertificateCommandConverterTest {

    private DivorceCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DivorceCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        DivorceCertificateCommand source = new DivorceCertificateCommandImpl();

        source.setId(id);

        DivorceCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
    }
}