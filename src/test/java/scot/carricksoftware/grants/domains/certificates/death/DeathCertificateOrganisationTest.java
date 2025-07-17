/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.places.Organisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


class DeathCertificateOrganisationTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getCertificateSourceTest() {
        assertNull(deathCertificate.getCertificateSource());
    }

    @Test
    void setCertificateSourceTest() {
        Organisation certificateSource = GetRandomOrganisation();
        deathCertificate.setCertificateSource(certificateSource);
        assertEquals(certificateSource, deathCertificate.getCertificateSource());
    }



}