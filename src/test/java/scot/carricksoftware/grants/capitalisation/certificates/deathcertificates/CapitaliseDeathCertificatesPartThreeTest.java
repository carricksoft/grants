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
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseDeathCertificatesPartThreeTest {

    @SuppressWarnings("unused")
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
    void spouseOccupationTest() {
        deathCertificateCommand.setSpouseOccupation("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getSpouseOccupation());
    }

    @Test
    void fatherOccupationTest() {
        deathCertificateCommand.setFatherOccupation("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getFatherOccupation());
    }

    @Test
    void motherOccupationTest() {
        deathCertificateCommand.setMotherOccupation("lower");
        capitaliseDeathCertificate.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getMotherOccupation());
    }


}