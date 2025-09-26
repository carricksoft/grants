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


class MarriageCertificateDatesMarriedTestTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getYearMarriedTest() {
        assertNull(marriageCertificate.getYearMarried());
    }

    @Test
    void setYearMarriedTest() {
        marriageCertificate.setYearMarried(string);
        assertEquals(string, marriageCertificate.getYearMarried());
    }

    @Test
    void getMonthMarriedTest() {
        assertNull(marriageCertificate.getMonthMarried());
    }

    @Test
    void setMonthMarriedTest() {
        marriageCertificate.setMonthMarried(string);
        assertEquals(string, marriageCertificate.getMonthMarried());
    }

    @Test
    void getDayMarriedTest() {
        assertNull(marriageCertificate.getDayMarried());
    }

    @Test
    void setDayMarriedTest() {
        marriageCertificate.setDayMarried(string);
        assertEquals(string, marriageCertificate.getDayMarried());
    }


}