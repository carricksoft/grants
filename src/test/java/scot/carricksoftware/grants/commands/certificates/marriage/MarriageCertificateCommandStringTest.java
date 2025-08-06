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


class MarriageCertificateCommandStringTest {

    private MarriageCertificateCommand marriageCertificateCommand;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhenMarriedTest() {
        assertNull(marriageCertificateCommand.getWhenMarried());
    }

    @Test
    void setUntrackedWhenMarriedTest() {
        marriageCertificateCommand.setWhenMarried(string);
        assertEquals(string, marriageCertificateCommand.getWhenMarried());
    }

    @Test
    void getGroomAgeTest() {
        assertNull(marriageCertificateCommand.getGroomAge());
    }

    @Test
    void setGroomAgeTest() {
        marriageCertificateCommand.setGroomAge(string);
        assertEquals(string, marriageCertificateCommand.getGroomAge());
    }

    @Test
    void getBrideAgeTest() {
        assertNull(marriageCertificateCommand.getBrideAge());
    }

    @Test
    void setBrideAgeTest() {
        marriageCertificateCommand.setBrideAge(string);
        assertEquals(string, marriageCertificateCommand.getBrideAge());
    }

    @Test
    void getGroomRankTest() {
        assertNull(marriageCertificateCommand.getGroomRank());
    }

    @Test
    void setGroomRankTest() {
        marriageCertificateCommand.setGroomRank(string);
        assertEquals(string, marriageCertificateCommand.getGroomRank());
    }


    @Test
    void getBrideRankTest() {
        assertNull(marriageCertificateCommand.getBrideRank());
    }

    @Test
    void setBrideRankTest() {
        marriageCertificateCommand.setBrideRank(string);
        assertEquals(string, marriageCertificateCommand.getBrideRank());
    }

    @Test
    void getGroomConditionTest() {
        assertNull(marriageCertificateCommand.getGroomCondition());
    }

    @Test
    void setGroomConditionTest() {
        marriageCertificateCommand.setGroomCondition(string);
        assertEquals(string, marriageCertificateCommand.getGroomCondition());
    }


    @Test
    void getBrideConditionTest() {
        assertNull(marriageCertificateCommand.getBrideCondition());
    }

    @Test
    void setBrideConditionTest() {
        marriageCertificateCommand.setBrideCondition(string);
        assertEquals(string, marriageCertificateCommand.getBrideCondition());
    }

    @Test
    void getBrideFatherRankTest() {
        assertNull(marriageCertificateCommand.getBrideFatherRank());
    }

    @Test
    void setBrideFatherRankTest() {
        marriageCertificateCommand.setBrideFatherRank(string);
        assertEquals(string, marriageCertificateCommand.getBrideFatherRank());
    }

    @Test
    void getGroomFatherRankTest() {
        assertNull(marriageCertificateCommand.getGroomFatherRank());
    }

    @Test
    void setGroomFatherRankTest() {
        marriageCertificateCommand.setGroomFatherRank(string);
        assertEquals(string, marriageCertificateCommand.getGroomFatherRank());
    }

}
    
