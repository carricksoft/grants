/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeathCertificateConverterCallsMilitaryConverterTest {

    private DeathCertificateConverter converter;
    private DeathCertificate deathCertificate;

    @Mock
    private DeathCertificateMilitaryConverter militaryConverterMock;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateConverterImpl(militaryConverterMock);
        deathCertificate = new DeathCertificate();
    }

    @Test
    void militaryConverterIsCalledTest() {
        DeathCertificateCommand deathCertificateCommand = converter.convert(deathCertificate);
        verify(militaryConverterMock).convert(deathCertificate, deathCertificateCommand);
    }
}