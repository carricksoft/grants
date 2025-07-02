/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


class BirthCertificateCommandUsualResidenceTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    void getFatherUsualResidenceTest() {
        assertNull(command.getFatherUsualResidence());
    }

    @Test
    void setFatherUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        command.setFatherUsualResidence(usualResidence);
        assertEquals(usualResidence, command.getFatherUsualResidence());
    }

    @Test
    void getFatherUntrackedUsualResidenceTest() {
        assertNull(command.getUntrackedFatherUsualResidence());
    }

    @Test
    void setFatherUntrackedUsualResidenceTest() {
        String untrackedUsualResidence = GetRandomString();
        command.setUntrackedFatherUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, command.getUntrackedFatherUsualResidence());
    }

    @Test
    void getMotherUsualResidenceTest() {
        assertNull(command.getMotherUsualResidence());
    }

    @Test
    void setMotherUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        command.setMotherUsualResidence(usualResidence);
        assertEquals(usualResidence, command.getMotherUsualResidence());
    }

    @Test
    void getMotherUntrackedUsualResidenceTest() {
        assertNull(command.getUntrackedMotherUsualResidence());
    }

    @Test
    void setMotherUntrackedUsualResidenceTest() {
        String untrackedUsualResidence = GetRandomString();
        command.setUntrackedMotherUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, command.getUntrackedMotherUsualResidence());
    }

    @Test
    void getInformantResidenceTest() {
        assertNull(command.getInformantResidence());
    }

    @Test
    void setInformantResidenceTest() {
        String informantResidence = GetRandomString();
        command.setInformantResidence(informantResidence);
        assertEquals(informantResidence, command.getInformantResidence());
    }

}