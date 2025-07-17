/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateStringTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getNumberTest() {
        assertEquals("",deathCertificate.getNumber());
    }

    @Test
    void setNumberTest() {
        String number = GetRandomString();
        deathCertificate.setNumber(number);
        assertEquals(number, deathCertificate.getNumber());
    }

    @Test
    void getVolumeTest() {
        assertNull(deathCertificate.getVolume());
    }

    @Test
    void setVolumeTest() {
        String volume = GetRandomString();
        deathCertificate.setVolume(volume);
        assertEquals(volume, deathCertificate.getVolume());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(deathCertificate.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        deathCertificate.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, deathCertificate.getCertificateNumber());
    }

}