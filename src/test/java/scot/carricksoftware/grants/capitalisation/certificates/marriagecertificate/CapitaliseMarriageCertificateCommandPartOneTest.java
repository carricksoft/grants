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
class CapitaliseMarriageCertificateCommandPartOneTest {

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
    void untrackedFirstWitnessTest() {
        marriageCertificateCommand.setUntrackedFirstWitness("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getUntrackedFirstWitness());
    }

    @Test
    void untrackedSecondWitnessTest() {
        marriageCertificateCommand.setUntrackedSecondWitness("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getUntrackedSecondWitness());
    }

    @Test
    void untrackedWhereMarriedTest() {
        marriageCertificateCommand.setUntrackedWhereMarried("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getUntrackedWhereMarried());
    }

    @Test
    void groomUntrackedResidenceTest() {
        marriageCertificateCommand.setGroomUntrackedResidence("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomUntrackedResidence());
    }

    @Test
    void brideUntrackedResidenceTest() {
        marriageCertificateCommand.setBrideUntrackedResidence("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideUntrackedResidence());
    }

    @Test
    void groomUntrackedFatherTest() {
        marriageCertificateCommand.setGroomUntrackedFather("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getGroomUntrackedFather());
    }

    @Test
    void brideUntrackedFatherTest() {
        marriageCertificateCommand.setBrideUntrackedFather("lower");
        capitaliseMarriageCertificateCommand.capitalise(marriageCertificateCommand);
        assertEquals("Lower", marriageCertificateCommand.getBrideUntrackedFather());
    }


}