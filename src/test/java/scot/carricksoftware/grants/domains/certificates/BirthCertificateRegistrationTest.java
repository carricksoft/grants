/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


class BirthCertificateRegistrationTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    void getRegistrationAuthorityTest() {
        assertNull(certificate.getRegistrationAuthority());
    }

    @Test
    void setRegistrationAuthorityTest() {
        Place registrationAuthority = GetRandomPlace();
        certificate.setRegistrationAuthority(registrationAuthority);
        assertEquals(registrationAuthority, certificate.getRegistrationAuthority());
    }

    @Test
    void getVolumeTest() {
        assertNull(certificate.getVolume());
    }

    @Test
    void setVolumeTest() {
        String volume = GetRandomString();
        certificate.setVolume(volume);
        assertEquals(volume, certificate.getVolume());
    }

    @Test
    void getNumberTest() {
        assertNull(certificate.getNumber());
    }

    @Test
    void setNumberTest() {
        String number = GetRandomString();
        certificate.setNumber(number);
        assertEquals(number, certificate.getNumber());
    }


}