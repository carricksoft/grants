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

class BirthCertificatePartFourTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    public void getMotherPlaceOfBirthTest() {
        assertNull(certificate.getMotherPlaceOfBirth());
    }

    @Test
    public void setMotherPlaceOfBirthTest() {
        String placeOfBirth = GetRandomString();
        certificate.setMotherPlaceOfBirth(placeOfBirth);
        assertEquals(placeOfBirth, certificate.getMotherPlaceOfBirth());
    }

    @Test
    public void getFatherPlaceOfBirthTest() {
        assertNull(certificate.getFatherPlaceOfBirth());
    }

    @Test
    public void setFatherPlaceOfBirthTest() {
        String placeOfBirth = GetRandomString();
        certificate.setFatherPlaceOfBirth(placeOfBirth);
        assertEquals(placeOfBirth, certificate.getFatherPlaceOfBirth());
    }

}