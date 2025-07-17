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


class DeathCertificateCommandStringTwoTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }
    
    @Test
    void getCauseOfDeathTest() {
        assertNull(deathCertificateCommand.getCauseOfDeath());
    }

    @Test
    void setCauseOfDeathTest() {
        String causeOfDeath = GetRandomString();
        deathCertificateCommand.setCauseOfDeath(causeOfDeath);
        assertEquals(causeOfDeath, deathCertificateCommand.getCauseOfDeath());
    }

    @Test
    void getInformantQualificationTest() {
        assertNull(deathCertificateCommand.getInformantQualification());
    }

    @Test
    void setInformantQualificationTest() {
        String informantQualification = GetRandomString();
        deathCertificateCommand.setInformantQualification(informantQualification);
        assertEquals(informantQualification, deathCertificateCommand.getInformantQualification());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(deathCertificateCommand.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        deathCertificateCommand.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, deathCertificateCommand.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(deathCertificateCommand.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        String certificateDate = GetRandomString();
        deathCertificateCommand.setCertificateDate(certificateDate);
        assertEquals(certificateDate, deathCertificateCommand.getCertificateDate());
    }

    @Test
    void getNumberTest() {
        assertNull(deathCertificateCommand.getNumber());
    }

    @Test
    void setNumberTest() {
        String number = GetRandomString();
        deathCertificateCommand.setNumber(number);
        assertEquals(number, deathCertificateCommand.getNumber());
    }

}