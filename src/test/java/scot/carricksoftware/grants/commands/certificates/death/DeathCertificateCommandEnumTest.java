/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeathCertificateCommandEnumTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getCertificateTypeTest() {
        assertNull(deathCertificateCommand.getCertificateType());
    }

    @Test
    void setCertificateTypeTest() {
        CertificateType certificateType = CertificateType.EXTRACT;
        deathCertificateCommand.setCertificateType(certificateType);
        assertEquals(certificateType, deathCertificateCommand.getCertificateType());
    }

}