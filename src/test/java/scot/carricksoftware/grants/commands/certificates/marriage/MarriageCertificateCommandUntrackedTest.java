/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateCommandUntrackedTest {

    private MarriageCertificateCommand marriageCertificateCommand;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhereMarriedTest() {
        assertNull(marriageCertificateCommand.getUntrackedWhereMarried());
    }

    @Test
    void setUntrackedWhereMarriedTest() {
        marriageCertificateCommand.setUntrackedWhereMarried(string);
        assertEquals(string, marriageCertificateCommand.getUntrackedWhereMarried());
    }

    @Test
    void getGroomUntrackedResidenceTest() {
        assertNull(marriageCertificateCommand.getGroomUntrackedResidence());
    }

    @Test
    void setGroomUntrackedResidenceTest() {
        marriageCertificateCommand.setGroomUntrackedResidence(string);
        assertEquals(string, marriageCertificateCommand.getGroomUntrackedResidence());
    }

    @Test
    void getBrideUntrackedResidenceTest() {
        assertNull(marriageCertificateCommand.getBrideUntrackedResidence());
    }

    @Test
    void setBrideUntrackedResidenceTest() {
        marriageCertificateCommand.setBrideUntrackedResidence(string);
        assertEquals(string, marriageCertificateCommand.getBrideUntrackedResidence());
    }


    @Test
    void getGroomUntrackedFatherTest() {
        assertNull(marriageCertificateCommand.getGroomUntrackedFather());
    }

    @Test
    void setGroomUntrackedFatherTest() {
        marriageCertificateCommand.setGroomUntrackedFather(string);
        assertEquals(string, marriageCertificateCommand.getGroomUntrackedFather());
    }

    @Test
    void getBrideUntrackedFatherTest() {
        assertNull(marriageCertificateCommand.getBrideUntrackedFather());
    }

    @Test
    void setBrideUntrackedFatherTest() {
        marriageCertificateCommand.setBrideUntrackedFather(string);
        assertEquals(string, marriageCertificateCommand.getBrideUntrackedFather());
    }

    @Test
    void getUntrackedFirstWitnessTest() {
        assertNull(marriageCertificateCommand.getUntrackedFirstWitness());
    }

    @Test
    void setUntrackedFirstWitnessTest() {
        marriageCertificateCommand.setUntrackedFirstWitness(string);
        assertEquals(string, marriageCertificateCommand.getUntrackedFirstWitness());
    }

    @Test
    void getUntrackedSecondWitnessTest() {
        assertNull(marriageCertificateCommand.getUntrackedSecondWitness());
    }

    @Test
    void setUntrackedSecondWitnessTest() {
        marriageCertificateCommand.setUntrackedSecondWitness(string);
        assertEquals(string, marriageCertificateCommand.getUntrackedSecondWitness());
    }


}