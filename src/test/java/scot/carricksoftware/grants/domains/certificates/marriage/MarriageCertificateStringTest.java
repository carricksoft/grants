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


class MarriageCertificateStringTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhenMarriedTest() {
        assertNull(marriageCertificate.getWhenMarried());
    }

    @Test
    void setUntrackedWhenMarriedTest() {
        marriageCertificate.setWhenMarried(string);
        assertEquals(string, marriageCertificate.getWhenMarried());
    }

    @Test
    void getGroomAgeTest() {
        assertNull(marriageCertificate.getGroomAge());
    }

    @Test
    void setGroomAgeTest() {
        marriageCertificate.setGroomAge(string);
        assertEquals(string, marriageCertificate.getGroomAge());
    }

    @Test
    void getBrideAgeTest() {
        assertNull(marriageCertificate.getBrideAge());
    }

    @Test
    void setBrideAgeTest() {
        marriageCertificate.setBrideAge(string);
        assertEquals(string, marriageCertificate.getBrideAge());
    }

    @Test
    void getGroomRankTest() {
        assertNull(marriageCertificate.getGroomRank());
    }

    @Test
    void setGroomRankTest() {
        marriageCertificate.setGroomRank(string);
        assertEquals(string, marriageCertificate.getGroomRank());
    }


    @Test
    void getBrideRankTest() {
        assertNull(marriageCertificate.getBrideRank());
    }

    @Test
    void setBrideRankTest() {
        marriageCertificate.setBrideRank(string);
        assertEquals(string, marriageCertificate.getBrideRank());
    }

    @Test
    void getGroomConditionTest() {
        assertNull(marriageCertificate.getGroomCondition());
    }

    @Test
    void setGroomConditionTest() {
        marriageCertificate.setGroomCondition(string);
        assertEquals(string, marriageCertificate.getGroomCondition());
    }


    @Test
    void getBrideConditionTest() {
        assertNull(marriageCertificate.getBrideCondition());
    }

    @Test
    void setBrideConditionTest() {
        marriageCertificate.setBrideCondition(string);
        assertEquals(string, marriageCertificate.getBrideCondition());
    }

    
 


}