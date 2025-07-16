/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateCommandUntrackedTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getUntrackedWhereDied() {
        assertNull(deathCertificateCommand.getUntrackedWhereDied());
    }

    @Test
    void setUntrackedWhereDied() {
        String untrackedWhereDied = GetRandomString();
        deathCertificateCommand.setUntrackedWhereDied(untrackedWhereDied);
        assertEquals(untrackedWhereDied, deathCertificateCommand.getUntrackedWhereDied());
    }

    @Test
    void getUntrackedSpouse() {
        assertNull(deathCertificateCommand.getUntrackedSpouse());
    }

    @Test
    void setUntrackedSpouse() {
        String untrackedSpouse = GetRandomString();
        deathCertificateCommand.setUntrackedSpouse(untrackedSpouse);
        assertEquals(untrackedSpouse, deathCertificateCommand.getUntrackedSpouse());
    }

    @Test
    void getUntrackedFather() {
        assertNull(deathCertificateCommand.getUntrackedFather());
    }

    @Test
    void setUntrackedFather() {
        String untrackedFather = GetRandomString();
        deathCertificateCommand.setUntrackedFather(untrackedFather);
        assertEquals(untrackedFather, deathCertificateCommand.getUntrackedFather());
    }

    @Test
    void getUntrackedMother() {
        assertNull(deathCertificateCommand.getUntrackedMother());
    }

    @Test
    void setUntrackedMother() {
        String untrackedMother = GetRandomString();
        deathCertificateCommand.setUntrackedMother(untrackedMother);
        assertEquals(untrackedMother, deathCertificateCommand.getUntrackedMother());
    }

    @Test
    void getUntrackedInformant() {
        assertNull(deathCertificateCommand.getUntrackedInformant());
    }

    @Test
    void setUntrackedInformant() {
        String untrackedInformant = GetRandomString();
        deathCertificateCommand.setUntrackedInformant(untrackedInformant);
        assertEquals(untrackedInformant, deathCertificateCommand.getUntrackedInformant());
    }

    @Test
    void getUntrackedUsualResidence() {
        assertNull(deathCertificateCommand.getUntrackedUsualResidence());
    }

    @Test
    void setUntrackedUsualResidence() {
        String untrackedUsualResidence = GetRandomString();
        deathCertificateCommand.setUntrackedUsualResidence(untrackedUsualResidence);
        assertEquals(untrackedUsualResidence, deathCertificateCommand.getUntrackedUsualResidence());
    }


}