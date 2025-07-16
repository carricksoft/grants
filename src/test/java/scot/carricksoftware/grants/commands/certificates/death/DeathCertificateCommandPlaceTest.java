/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


class DeathCertificateCommandPlaceTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }


    @Test
    void getWhereRegisteredTest() {
        assertNull(deathCertificateCommand.getWhereRegistered());
    }

    @Test
    void setWhereRegisteredTest() {
        String whereRegistered = GetRandomString();
        deathCertificateCommand.setWhereRegistered(whereRegistered);
        assertEquals(whereRegistered, deathCertificateCommand.getWhereRegistered());
    }

    @Test
    void getInformantAddressTest() {
        assertNull(deathCertificateCommand.getInformantAddress());
    }

    @Test
    void setInformantAddressTest() {
        String informantAddress = GetRandomString();
        deathCertificateCommand.setInformantAddress(informantAddress);
        assertEquals(informantAddress, deathCertificateCommand.getInformantAddress());
    }

    @Test
    void getWhereDiedTest() {
        assertNull(deathCertificateCommand.getWhereDied());
    }

    @Test
    void setWhereDiedTest() {
        Place whereDied = GetRandomPlace();
        deathCertificateCommand.setWhereDied(whereDied);
        assertEquals(whereDied, deathCertificateCommand.getWhereDied());
    }

    @Test
    void getUsualResidenceTest() {
        assertNull(deathCertificateCommand.getUsualResidence());
    }

    @Test
    void setUsualResidenceTest() {
        Place usualResidence = GetRandomPlace();
        deathCertificateCommand.setUsualResidence(usualResidence);
        assertEquals(usualResidence, deathCertificateCommand.getUsualResidence());
    }

}