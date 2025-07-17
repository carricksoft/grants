/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Organisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeathCertificateCommandOrganisationTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getRegistrationAuthorityTest() {
        assertNull(deathCertificateCommand.getRegistrationAuthority());
    }

    @Test
    void setRegistrationAuthorityTest() {
        Organisation registrationAuthority = new Organisation();
        deathCertificateCommand.setRegistrationAuthority(registrationAuthority);
        assertEquals(registrationAuthority, deathCertificateCommand.getRegistrationAuthority());
    }



}