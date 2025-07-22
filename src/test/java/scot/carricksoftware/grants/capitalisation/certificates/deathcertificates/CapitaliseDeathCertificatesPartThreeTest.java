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

import static org.junit.jupiter.api.Assertions.assertNotNull;


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
    }

   @Test
   void constructorTest(){
        assertNotNull(deathCertificateCommand);
   }


}