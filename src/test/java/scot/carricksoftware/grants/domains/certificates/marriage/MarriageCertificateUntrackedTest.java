/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateUntrackedTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhereMarriedTest() {
        assertNull(marriageCertificate.getUntrackedWhereMarried());
    }

    @Test
    void setUntrackedWhereMarriedTest() {
        marriageCertificate.setUntrackedWhereMarried(string);
        assertEquals(string, marriageCertificate.getUntrackedWhereMarried());
    }

    @Test
    void getGroomUntrackedResidenceTest() {
        assertNull(marriageCertificate.getGroomUntrackedResidence());
    }

    @Test
    void setGroomUntrackedResidenceTest() {
        marriageCertificate.setGroomUntrackedResidence(string);
        assertEquals(string, marriageCertificate.getGroomUntrackedResidence());
    }


    @Test
    void getGroomUntrackedFatherTest() {
        assertNull(marriageCertificate.getGroomUntrackedFather());
    }

    @Test
    void setGroomUntrackedFatherTest() {
        marriageCertificate.setGroomUntrackedFather(string);
        assertEquals(string, marriageCertificate.getGroomUntrackedFather());
    }

    @Test
    void getBrideUntrackedFatherTest() {
        assertNull(marriageCertificate.getBrideUntrackedFather());
    }

    @Test
    void setBrideUntrackedFatherTest() {
        marriageCertificate.setBrideUntrackedFather(string);
        assertEquals(string, marriageCertificate.getBrideUntrackedFather());
    }

    @Test
    void getUntrackedFirstWitnessTest() {
        assertNull(marriageCertificate.getUntrackedFirstWitness());
    }

    @Test
    void setUntrackedFirstWitnessTest() {
        marriageCertificate.setUntrackedFirstWitness(string);
        assertEquals(string, marriageCertificate.getUntrackedFirstWitness());
    }

    @Test
    void getUntrackedSecondWitnessTest() {
        assertNull(marriageCertificate.getUntrackedSecondWitness());
    }

    @Test
    void setUntrackedSecondWitnessTest() {
        marriageCertificate.setUntrackedSecondWitness(string);
        assertEquals(string, marriageCertificate.getUntrackedSecondWitness());
    }


}