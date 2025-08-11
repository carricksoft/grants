/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateBrideCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateCertificateCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateDateCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateGroomCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateWitnessCommandConverter;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateCommandConverterTest {

    private MarriageCertificateCommandConverter converter;

    @Mock
    private MarriageCertificateBrideCommandConverter marriageCertificateBrideConverterMock;

    @Mock
    private MarriageCertificateGroomCommandConverter marriageCertificateGroomConverterMock;

    @Mock
    private MarriageCertificateWitnessCommandConverter marriageCertificateWitnessConverterMock;

    @Mock
    private MarriageCertificateCertificateCommandConverter marriageCertificateCertificateConverterMock;

    @Mock
    private MarriageCertificateDateCommandConverter marriageCertificateDateConverterMock;

    private MarriageCertificateCommand marriageCertificateCommand;


    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateCommandConverterImpl(
                marriageCertificateBrideConverterMock,
                marriageCertificateGroomConverterMock,
                marriageCertificateWitnessConverterMock,
                marriageCertificateCertificateConverterMock,
                marriageCertificateDateConverterMock);


        marriageCertificateCommand = new MarriageCertificateCommandImpl();
    }

    @Test
    void helpersGetCalledTest() {
        MarriageCertificate certificate = converter.convert(marriageCertificateCommand);
        verify(marriageCertificateBrideConverterMock).convert(marriageCertificateCommand, certificate);
        verify(marriageCertificateGroomConverterMock).convert(marriageCertificateCommand, certificate);
        verify(marriageCertificateWitnessConverterMock).convert(marriageCertificateCommand, certificate);
        verify(marriageCertificateCertificateConverterMock).convert(marriageCertificateCommand, certificate);
        verify(marriageCertificateDateConverterMock).convert(marriageCertificateCommand, certificate);
    }
}