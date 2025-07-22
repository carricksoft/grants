/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificate.CapitaliseDeathCertificate;
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificate.CapitaliseDeathCertificateImpl;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseDeathCertificatesPartOneTest {

    private CapitaliseDeathCertificate capitaliseDeathCertificate;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseDeathCertificate = new CapitaliseDeathCertificateImpl(capitaliseStringMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void informantQualificationTest() {
        deathCertificateCommand.setInformantQualification("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getInformantQualification());
    }

    @Test
    void untrackedWhereBornTest() {
        deathCertificateCommand.setUntrackedWhereDied("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getUntrackedWhereDied());
    }

    @Test
    void untrackedFatherTest() {
        deathCertificateCommand.setUntrackedFather("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getUntrackedFather());
    }

    @Test
    void untrackedInformantTest() {
        deathCertificateCommand.setUntrackedInformant("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getUntrackedInformant());
    }


}