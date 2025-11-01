/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.deathcertificate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificates.CapitaliseDeathCertificateCommand;
import scot.carricksoftware.grants.capitalisation.certificates.deathcertificates.CapitaliseDeathCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseDeathCertificateCommandPartThreeTest {

    @SuppressWarnings("unused")
    private CapitaliseDeathCertificateCommand capitaliseDeathCertificateCommand;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseDeathCertificateCommand = new CapitaliseDeathCertificateCommandImpl(capitaliseStringMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void spouseOccupationTest() {
        deathCertificateCommand.setSpouseOccupation("lower");
        capitaliseDeathCertificateCommand.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getSpouseOccupation());
    }

    @Test
    void fatherOccupationTest() {
        deathCertificateCommand.setFatherOccupation("lower");
        capitaliseDeathCertificateCommand.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getFatherOccupation());
    }

    @Test
    void motherOccupationTest() {
        deathCertificateCommand.setMotherOccupation("lower");
        capitaliseDeathCertificateCommand.capitalise(deathCertificateCommand);
        assertEquals("Lower", deathCertificateCommand.getMotherOccupation());
    }


}