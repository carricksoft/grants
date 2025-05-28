/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomDateValues.GetRandomDate;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class BaseCertificateCommandTest {

    private BaseCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BaseCertificateCommandImpl();
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        command.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, command.getCertificateNumber());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(command.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(command.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        Date certificateDate = GetRandomDate();
        command.setCertificateDate(certificateDate);
        assertEquals(certificateDate, command.getCertificateDate());
    }

    @Test
    void getCertificateIssuedAtTest() {
        assertNull(command.getCertificateIssuedAt());
    }

    @Test
    void setCertificateIssuedAtTest() {
        Place issuedAt = GetRandomPlace();
        command.setCertificateIssuedAt(issuedAt);
        assertEquals(issuedAt, command.getCertificateIssuedAt());
    }
}