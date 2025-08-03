/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeathCertificateCommandCallsMilitaryConverterTest {

    private DeathCertificateCommandConverter converter;
    private DeathCertificateCommand deathCertificateCommand;

    @Mock
    private DeathCertificateCommandMilitaryConverter deathCertificateCommandMilitaryConverterMock;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl(deathCertificateCommandMilitaryConverterMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void converterTest() {
        DeathCertificate deathCertificate = converter.convert(deathCertificateCommand);
        verify(deathCertificateCommandMilitaryConverterMock).convert(deathCertificateCommand, deathCertificate);
    }
}