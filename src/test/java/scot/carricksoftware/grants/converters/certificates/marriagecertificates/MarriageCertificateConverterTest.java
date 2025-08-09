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
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateBrideConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateCertificateConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateGroomConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateWitnessConverter;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateConverterTest {

    private MarriageCertificateConverter converter;

    @Mock
    private MarriageCertificateBrideConverter marriageCertificateBrideConverterMock;

    @Mock
    private MarriageCertificateGroomConverter marriageCertificateGroomConverterMock;

    @Mock
    private MarriageCertificateWitnessConverter marriageCertificateWitnessConverterMock;

    @Mock
    private MarriageCertificateCertificateConverter marriageCertificateCertificateConverterMock;

    private MarriageCertificate marriageCertificate;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateConverterImpl(
                marriageCertificateBrideConverterMock,
                marriageCertificateGroomConverterMock,
                marriageCertificateWitnessConverterMock,
                marriageCertificateCertificateConverterMock);
        marriageCertificate = new MarriageCertificate();
    }

    @Test
    void helpersGetCalledTest() {
        MarriageCertificateCommand certificateCommand = converter.convert(marriageCertificate);
        verify(marriageCertificateBrideConverterMock).convert(marriageCertificate, certificateCommand);
        verify(marriageCertificateGroomConverterMock).convert(marriageCertificate, certificateCommand);
        verify(marriageCertificateWitnessConverterMock).convert(marriageCertificate, certificateCommand);
        verify(marriageCertificateCertificateConverterMock).convert(marriageCertificate, certificateCommand);
    }


}