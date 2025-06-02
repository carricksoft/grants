/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.enums.censusentry.CensusEntrySex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.GetRandomCensusEntrySex;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class BirthCertificatePartTwoTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    public void getWhenBornTest() {
        assertNull(certificate.getWhenBorn());
    }

    @Test
    public void setWhenBornTest() {
        String string;
        certificate.setWhenBorn(string = GetRandomString());
        assertEquals(string, certificate.getWhenBorn());
    }

    @Test
    public void getWhereBornTest() {
        assertNull(certificate.getWhereBorn());
    }

    @Test
    public void setWhereBornTest() {
        String string;
        certificate.setWhereBorn(string = GetRandomString());
        assertEquals(string, certificate.getWhereBorn());
    }

    @Test
    public void getSexTestTest() {
        assertNull(certificate.getWhenBorn());
    }

    @Test
    void setSexTest() {
        CensusEntrySex sex = GetRandomCensusEntrySex();
        certificate.setSex(sex);
        assertEquals(sex, certificate.getSex());
    }

}