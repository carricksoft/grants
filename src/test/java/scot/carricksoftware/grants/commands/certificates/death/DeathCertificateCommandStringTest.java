/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class DeathCertificateCommandStringTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getSexTest() {
        assertNull(deathCertificateCommand.getSex());
    }

    @Test
    void setSexTest() {
        Sex sex = Sex.MALE;
        deathCertificateCommand.setSex(sex);
        assertEquals(sex, deathCertificateCommand.getSex());
    }

    @Test
    void getOccupationTest() {
        assertNull(deathCertificateCommand.getOccupation());
    }

    @Test
    void setOccupationTest() {
        String occupation = GetRandomString();
        deathCertificateCommand.setOccupation(occupation);
        assertEquals(occupation, deathCertificateCommand.getOccupation());
    }

    @Test
    void getSpouseOccupationTest() {
        assertNull(deathCertificateCommand.getSpouseOccupation());
    }

    @Test
    void setSpouseOccupationTest() {
        String spouseOccupation = GetRandomString();
        deathCertificateCommand.setSpouseOccupation(spouseOccupation);
        assertEquals(spouseOccupation, deathCertificateCommand.getSpouseOccupation());
    }

    @Test
    void getFatherOccupationTest() {
        assertNull(deathCertificateCommand.getFatherOccupation());
    }

    @Test
    void setFatherOccupationTest() {
        String fatherOccupation = GetRandomString();
        deathCertificateCommand.setFatherOccupation(fatherOccupation);
        assertEquals(fatherOccupation, deathCertificateCommand.getFatherOccupation());
    }

    @Test
    void getMotherOccupationTest() {
        assertNull(deathCertificateCommand.getMotherOccupation());
    }

    @Test
    void setMotherOccupationTest() {
        String motherOccupation = GetRandomString();
        deathCertificateCommand.setMotherOccupation(motherOccupation);
        assertEquals(motherOccupation, deathCertificateCommand.getMotherOccupation());
    }

    @Test
    void getMaritalStatusTest() {
        assertNull(deathCertificateCommand.getMaritalStatus());
    }

    @Test
    void setMaritalStatusTest() {
        String maritalStatus = GetRandomString();
        deathCertificateCommand.setMaritalStatus(maritalStatus);
        assertEquals(maritalStatus, deathCertificateCommand.getMaritalStatus());
    }




}