/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.divorce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


class DivorceCertificateIDTest {

    private DivorceCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new DivorceCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(certificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        certificate.setId(id);
        assertEquals(id, certificate.getId());
    }



}