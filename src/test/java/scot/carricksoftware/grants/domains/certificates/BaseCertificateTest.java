/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class BaseCertificateTest {

    private BaseCertificate baseCertificate;

    @BeforeEach
    void setUp() {
        baseCertificate = new BaseCertificate();
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(baseCertificate.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        baseCertificate.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, baseCertificate.getCertificateNumber());
    }
}