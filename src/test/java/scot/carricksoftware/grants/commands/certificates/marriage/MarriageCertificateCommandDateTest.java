/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateCommandDateTest {

    private MarriageCertificateCommand marriageCertificateCommand;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        string = GetRandomString();
    }

    @Test
    void getYearMarriedTest() {
        assertNull(marriageCertificateCommand.getYearMarried());
    }

    @Test
    void setYearMarriedTest() {
        marriageCertificateCommand.setYearMarried(string);
        assertEquals(string, marriageCertificateCommand.getYearMarried());
    }

    @Test
    void getMonthMarriedTest() {
        assertNull(marriageCertificateCommand.getMonthMarried());
    }

    @Test
    void setMonthMarriedTest() {
        marriageCertificateCommand.setMonthMarried(string);
        assertEquals(string, marriageCertificateCommand.getMonthMarried());
    }

    @Test
    void getDayMarriedTest() {
        assertNull(marriageCertificateCommand.getDayMarried());
    }

    @Test
    void setDayMarriedTest() {
        marriageCertificateCommand.setDayMarried(string);
        assertEquals(string, marriageCertificateCommand.getDayMarried());
    }

}
    
