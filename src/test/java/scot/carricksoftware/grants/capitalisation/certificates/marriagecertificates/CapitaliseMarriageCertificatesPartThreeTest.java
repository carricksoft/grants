/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseMarriageCertificatesPartThreeTest {

    private CapitaliseMarriageCertificate capitaliseMarriageCertificate;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseMarriageCertificate = new CapitaliseMarriageCertificateImpl(capitaliseStringMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void brideRankTest() {
        marriageCertificateCommand.setBrideRank("lower");
        capitaliseMarriageCertificate.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideRank());
    }

    @Test
    void groomRankTest() {
        marriageCertificateCommand.setGroomRank("lower");
        capitaliseMarriageCertificate.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomRank());
    }

    @Test
    void groomFatherRankTest() {
        marriageCertificateCommand.setGroomFatherRank("lower");
        capitaliseMarriageCertificate.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomFatherRank());
    }

    @Test
    void brideFatherRankTest() {
        marriageCertificateCommand.setBrideFatherRank("lower");
        capitaliseMarriageCertificate.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideFatherRank());
    }


}