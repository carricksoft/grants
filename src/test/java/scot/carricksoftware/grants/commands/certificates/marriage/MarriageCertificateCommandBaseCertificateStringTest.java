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


class MarriageCertificateCommandBaseCertificateStringTest {

    private MarriageCertificateCommand command;
    private String string;

    @BeforeEach
    void setUp() {
        command = new MarriageCertificateCommandImpl();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhenMarriedTest() {
        assertNull(command.getWhenMarried());
    }

    @Test
    void setUntrackedWhenMarriedTest() {
        command.setWhenMarried(string);
        assertEquals(string, command.getWhenMarried());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(command.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        command.setCertificateNumber(string);
        assertEquals(string, command.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(command.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        command.setCertificateDate(string);
        assertEquals(string, command.getCertificateDate());
    }

    @Test
    void getRegistrationAuthorityTest() {
        assertNull(command.getRegistrationAuthority());
    }

    @Test
    void getVolumeTest() {
        assertNull(command.getVolume());
    }

    @Test
    void setVolumeTest() {
        command.setVolume(string);
        assertEquals(string, command.getVolume());
    }

    @Test
    void getNumberTest() {
        assertNull(command.getNumber());
    }

    @Test
    void setNumberTest() {
        command.setNumber(string);
        assertEquals(string, command.getNumber());
    }


}
    
