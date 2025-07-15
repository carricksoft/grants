/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class BirthCertificateRegisteredTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    void getWhenRegisteredTest() {
        assertNull(certificate.getWhenRegistered());
    }

    @Test
    void setWhenRegisteredTest() {
        String whenRegistered = GetRandomString();
        certificate.setWhenRegistered(whenRegistered);
        assertEquals(whenRegistered, certificate.getWhenRegistered());
    }

    @Test
    void getWhereRegisteredTest() {
        assertNull(certificate.getWhereRegistered());
    }

    @Test
    void setWhereRegisteredTest() {
        String whereRegistered = GetRandomString();
        certificate.setWhereRegistered(whereRegistered);
        assertEquals(whereRegistered, certificate.getWhereRegistered());
    }

}