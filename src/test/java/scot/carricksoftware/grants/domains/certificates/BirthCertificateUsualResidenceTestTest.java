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


class BirthCertificateUsualResidenceTestTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    void getFatherUsualResidenceTest() {
        assertNull(certificate.getFatherUsualResidence());
    }

    @Test
    void setFatherUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        certificate.setFatherUsualResidence(usualResidence);
        assertEquals(usualResidence, certificate.getFatherUsualResidence());
    }

    @Test
    void getFatherUntrackedUsualResidenceTest() {
        assertNull(certificate.getUntrackedFatherUsualResidence());
    }

    @Test
    void setFatherUntrackedUsualResidenceTest() {
        String untrackedUsualResidence = GetRandomString();
        certificate.setUntrackedFatherUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, certificate.getUntrackedFatherUsualResidence());
    }

    @Test
    void getMotherUsualResidenceTest() {
        assertNull(certificate.getMotherUsualResidence());
    }

    @Test
    void setMotherUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        certificate.setMotherUsualResidence(usualResidence);
        assertEquals(usualResidence, certificate.getMotherUsualResidence());
    }

    @Test
    void getUntrackedMotherUsualResidenceTest() {
        assertNull(certificate.getUntrackedMotherUsualResidence());
    }

    @Test
    void setUntrackedMotherUsualResidenceTest() {
        String untrackedUsualResidence = GetRandomString();
        certificate.setUntrackedMotherUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, certificate.getUntrackedMotherUsualResidence());
    }
}