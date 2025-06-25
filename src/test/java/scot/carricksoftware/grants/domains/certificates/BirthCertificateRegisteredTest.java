/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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