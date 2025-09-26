/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class MarriageCertificateDateCommandConverterTest {

    private MarriageCertificateDateCommandConverter converter;

    private MarriageCertificateCommand source;
    private MarriageCertificate target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateDateCommandConverterImpl();
        source = new MarriageCertificateCommandImpl();
        target = new MarriageCertificate();
    }

    @Test
    void convertTest() {
        source.setYearMarried(GetRandomString());
        source.setMonthMarried(GetRandomString());
        source.setDayMarried(GetRandomString());

        converter.convert(source, target);

        assertEquals(source.getYearMarried(), target.getYearMarried());
        assertEquals(source.getMonthMarried(), target.getMonthMarried());
        assertEquals(source.getDayMarried(), target.getDayMarried());
    }

}