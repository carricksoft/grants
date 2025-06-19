/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.GetRandomCensusEntrySex;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class BirthCertificateCommandThreeFieldsTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    public void getWhenBornTest() {
        assertNull(command.getWhenBorn());
    }

    @Test
    public void setWhenBornTest() {
        String string;
        command.setWhenBorn(string = GetRandomString());
        assertEquals(string, command.getWhenBorn());
    }

    @Test
    public void getUntrackedWhereBornTest() {
        assertNull(command.getUntrackedWhereBorn());
    }

    @Test
    public void setUntrackedWhereBornTest() {
        String string;
        command.setUntrackedWhereBorn(string = GetRandomString());
        assertEquals(string, command.getUntrackedWhereBorn());
    }

    @Test
    public void getSexTest() {
        assertNull(command.getWhenBorn());
    }

    @Test
    void setSexTest() {
        Sex sex = GetRandomCensusEntrySex();
        command.setSex(sex);
        assertEquals(sex, command.getSex());
    }

}