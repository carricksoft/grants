/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.marriagecertificate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates.CapitaliseMarriageCertificateCommand;
import scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates.CapitaliseMarriageCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseMarriageCertificateCommandPartThreeTest {

    private CapitaliseMarriageCertificateCommand capitaliseMarriageCertificateCommand;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseMarriageCertificateCommand = new CapitaliseMarriageCertificateCommandImpl(capitaliseStringMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }

    @Test
    void brideRankTest() {
        marriageCertificateCommand.setBrideRank("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideRank());
    }

    @Test
    void groomRankTest() {
        marriageCertificateCommand.setGroomRank("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomRank());
    }

    @Test
    void groomFatherRankTest() {
        marriageCertificateCommand.setGroomFatherRank("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomFatherRank());
    }

    @Test
    void brideFatherRankTest() {
        marriageCertificateCommand.setBrideFatherRank("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideFatherRank());
    }


}