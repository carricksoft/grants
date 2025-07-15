/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }


    @Test
    void getSexTest() {
        assertNull(deathCertificate.getSex());
    }

    @Test
    void setSexTest() {
        Sex sex = Sex.MALE;
        deathCertificate.setSex(sex);
        assertEquals(sex, deathCertificate.getSex());
    }

    @Test
    void getOccupationTest() {
        assertNull(deathCertificate.getOccupation());
    }

    @Test
    void setOccupationTest() {
        String occupation = GetRandomString();
        deathCertificate.setOccupation(occupation);
        assertEquals(occupation, deathCertificate.getOccupation());
    }

}