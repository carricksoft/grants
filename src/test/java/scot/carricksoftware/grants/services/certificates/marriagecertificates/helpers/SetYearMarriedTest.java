/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class SetYearMarriedTest {

    SetYearMarried setYearMarried;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        setYearMarried = new SetYearMarriedImpl();
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
    }

    @Test
    void validTest() {
        marriageCertificateCommand.setWhenMarried("25/01/1953");
        setYearMarried.setDatesMarried(marriageCertificateCommand);

        assertEquals("1953", marriageCertificateCommand.getYearMarried());
        assertEquals("01", marriageCertificateCommand.getMonthMarried());
        assertEquals("25", marriageCertificateCommand.getDayMarried());
    }

    @Test
    void invalidStringTest() {
        //noinspection SpellCheckingInspection
        marriageCertificateCommand.setWhenMarried("zzzz");
        marriageCertificateCommand.setYearMarried(GetRandomString());
        marriageCertificateCommand.setMonthMarried(GetRandomString());
        marriageCertificateCommand.setDayMarried(GetRandomString());

        setYearMarried.setDatesMarried(marriageCertificateCommand);

        assertNull(marriageCertificateCommand.getYearMarried());
        assertNull(marriageCertificateCommand.getMonthMarried());
        assertNull(marriageCertificateCommand.getDayMarried());
    }

    @Test
    void invalidDateTest() {
        marriageCertificateCommand.setWhenMarried("25/18/1953");
        setYearMarried.setDatesMarried(marriageCertificateCommand);

        assertNull(marriageCertificateCommand.getYearMarried());
        assertNull(marriageCertificateCommand.getMonthMarried());
        assertNull(marriageCertificateCommand.getDayMarried());
    }
}