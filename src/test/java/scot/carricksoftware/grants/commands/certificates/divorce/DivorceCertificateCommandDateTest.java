/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class DivorceCertificateCommandDateTest {

    private DivorceCertificateCommand command;

    private String date;

    @BeforeEach
    void setUp() {
        command = new DivorceCertificateCommandImpl();
        date = GetRandomString();
    }

    @Test
    public void getRegisteredDateTest() {
        assertNull(command.getRegisteredDate());
    }

    @Test
    public void setRegisteredDateTest() {
        command.setRegisteredDate(date);
        assertEquals(date, command.getRegisteredDate());
    }

    @Test
    public void getFirstPartyDateTest() {
        assertNull(command.getFirstPartyDate());
    }

    @Test
    public void setFirstPartyDateTest() {
        command.setFirstPartyDate(date);
        assertEquals(date, command.getFirstPartyDate());
    }

    @Test
    public void getSecondPartyDateTest() {
        assertNull(command.getSecondPartyDate());
    }

    @Test
    public void setSecondPartyDateTest() {
        command.setSecondPartyDate(date);
        assertEquals(date, command.getSecondPartyDate());
    }

}