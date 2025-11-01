/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.birthcertificate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseBirthCertificateCommandPartOneTest {

    private CapitaliseBirthCertificateCommand capitaliseBirthCertificateCommand;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private BirthCertificateCommand birthCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseBirthCertificateCommand = new CapitaliseBirthCertificateCommandImpl(capitaliseStringMock);
        birthCertificateCommand = new BirthCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void informantQualificationTest() {
        birthCertificateCommand.setInformantQualification("lower");
        capitaliseBirthCertificateCommand.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getInformantQualification());
    }

    @Test
    void untrackedWhereBornTest() {
        birthCertificateCommand.setUntrackedWhereBorn("lower");
        capitaliseBirthCertificateCommand.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedWhereBorn());
    }

    @Test
    void untrackedFatherTest() {
        birthCertificateCommand.setUntrackedFather("lower");
        capitaliseBirthCertificateCommand.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedFather());
    }


    @Test
    void untrackedInformantTest() {
        birthCertificateCommand.setUntrackedInformant("lower");
        capitaliseBirthCertificateCommand.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedInformant());
    }


}