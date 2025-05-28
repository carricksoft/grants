/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class BaseCertificateTest {

    private BaseCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BaseCertificate();
    }

    @Test
    void dummyTest(){
        assertNotNull(certificate);
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(certificate.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        certificate.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, certificate.getCertificateNumber());
    }


    @Test
    void getCertificateDateTest() {
        assertNull(certificate.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        Date certificateDate = Date.valueOf(LocalDate.now());
        certificate.setCertificateDate(certificateDate);
        assertEquals(certificateDate, certificate.getCertificateDate());
    }

    @Test
    void getCertificateIssuedAtTest() {
        Place place = GetRandomPlace();
        certificate.setCertificateIssuedAt(place);
        assertEquals(place, certificate.getCertificateIssuedAt());
    }

}