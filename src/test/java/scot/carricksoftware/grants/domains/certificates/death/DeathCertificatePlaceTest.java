/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


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

}