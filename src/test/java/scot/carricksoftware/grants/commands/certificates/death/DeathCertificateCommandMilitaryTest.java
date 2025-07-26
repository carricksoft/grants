/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class DeathCertificateCommandMilitaryTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getRegimentTest() {
        assertNull(deathCertificateCommand.getRegiment());
    }

    @Test
    void setRegimentTest() {
        String regiment = GetRandomString();
        deathCertificateCommand.setRegiment(regiment);
        assertEquals(regiment, deathCertificateCommand.getRegiment());
    }

    @Test
    void getServiceNumberTest() {
        assertNull(deathCertificateCommand.getServiceNumber());
    }

    @Test
    void setServiceNumberTest() {
        String serviceNumber = GetRandomString();
        deathCertificateCommand.setServiceNumber(serviceNumber);
        assertEquals(serviceNumber, deathCertificateCommand.getServiceNumber());
    }

    @Test
    void getServiceRankTest() {
        assertNull(deathCertificateCommand.getServiceRank());
    }

    @Test
    void setServiceRankTest() {
        String serviceRank = GetRandomString();
        deathCertificateCommand.setServiceRank(serviceRank);
        assertEquals(serviceRank, deathCertificateCommand.getServiceRank());
    }

}