/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class DeathCertificateMilitaryConverterTest {

    private DeathCertificateMilitaryConverter militaryConverter;
    private DeathCertificate source;
    private DeathCertificateCommand target;


    @BeforeEach
    void setUp() {
        militaryConverter = new DeathCertificateMilitaryConverterImpl();
        source = new DeathCertificate();
        target = new DeathCertificateCommandImpl();
    }

    @Test
    void convertTest() {
        String regiment = GetRandomString();
        String serviceNumber = GetRandomString();
        String serviceRank = GetRandomString();

        source.setRegiment(regiment);
        source.setServiceNumber(serviceNumber);
        source.setServiceRank(serviceRank);

        militaryConverter.convert(source, target);

        assertEquals(regiment, target.getRegiment());
        assertEquals(serviceNumber, target.getServiceNumber());
        assertEquals(serviceRank, target.getServiceRank());
    }


}