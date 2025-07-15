/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


class DeathCertificatePlaceTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }


    @Test
    void getWhereRegisteredTest() {
        assertNull(deathCertificate.getWhereRegistered());
    }

    @Test
    void setWhereRegisteredTest() {
        String whereRegistered = GetRandomString();
        deathCertificate.setWhereRegistered(whereRegistered);
        assertEquals(whereRegistered, deathCertificate.getWhereRegistered());
    }

    @Test
    void getInformantAddressTest() {
        assertNull(deathCertificate.getInformantAddress());
    }

    @Test
    void setInformantAddressTest() {
        String informantAddress = GetRandomString();
        deathCertificate.setInformantAddress(informantAddress);
        assertEquals(informantAddress, deathCertificate.getInformantAddress());
    }

    @Test
    void getWhereDiedTest() {
        assertNull(deathCertificate.getWhereDied());
    }

    @Test
    void setWhereDiedTest() {
        Place whereDied = GetRandomPlace();
        deathCertificate.setWhereDied(whereDied);
        assertEquals(whereDied, deathCertificate.getWhereDied());
    }

    @Test
    void getUsualResidenceTest() {
        assertNull(deathCertificate.getUsualResidence());
    }

    @Test
    void setUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        deathCertificate.setUsualResidence(usualResidence);
        assertEquals(usualResidence, deathCertificate.getUsualResidence());
    }

}