/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CapitaliseBirthCertificateCommandTest {

    private final CapitaliseStringImpl capitaliseString = new CapitaliseStringImpl();

    @SuppressWarnings("unused")
    private Capitalise capitalise;

    @BeforeEach
    void setUp() {
        capitalise = new CapitaliseImpl(capitaliseString);
    }

    @Test
    void birthCertificateCommandTest() {
        BirthCertificateCommand command = new BirthCertificateCommandImpl();
        command.setInformantQualification("lower1");
        command.setUntrackedInformant("lower2");
        command.setUntrackedWhereBorn("lower3");
        command.setUntrackedFather("lower4");
        command.setWhenBorn("lower5");
        command.setCertificateNumber("lower6");

        capitalise.capitaliseBirthCertificateCommand(command);
        assertEquals("Lower1", command.getInformantQualification());
        assertEquals("Lower2", command.getUntrackedInformant());
        assertEquals("Lower3", command.getUntrackedWhereBorn());
        assertEquals("Lower4", command.getUntrackedFather());
        assertEquals("Lower5", command.getWhenBorn());
        assertEquals("Lower6", command.getCertificateNumber());
    }
}