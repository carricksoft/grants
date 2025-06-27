/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.capitalisation.certificates.birthcertificate.CapitaliseBirthCertificate;
import scot.carricksoftware.grants.capitalisation.certificates.birthcertificate.CapitaliseBirthCertificateImpl;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseBirthCertificatesPartOneTest {

    private CapitaliseBirthCertificate capitaliseBirthCertificate;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private BirthCertificateCommand birthCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseBirthCertificate = new CapitaliseBirthCertificateImpl(capitaliseStringMock);
        birthCertificateCommand = new BirthCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void informantQualificationTest() {
        birthCertificateCommand.setInformantQualification("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getInformantQualification());
    }

    @Test
    void untrackedWhereBornTest() {
        birthCertificateCommand.setUntrackedWhereBorn("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedWhereBorn());
    }

    @Test
    void untrackedFatherTest() {
        birthCertificateCommand.setUntrackedFather("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedFather());
    }

    @Test
    void untrackedInformantTest() {
        birthCertificateCommand.setUntrackedInformant("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedInformant());
    }


}