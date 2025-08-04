/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


class MarriageCertificateCommandPlaceTest {

    private MarriageCertificateCommand marriageCertificateCommand;
    private Place place;

    @BeforeEach
    void setUp() {
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        place = GetRandomPlace();
    }

    @Test
    void getWhereMarriedTest() {
        assertNull(marriageCertificateCommand.getWhereMarried());
    }

    @Test
    void setWhereMarriedTest() {
        marriageCertificateCommand.setWhereMarried(place);
        assertEquals(place, marriageCertificateCommand.getWhereMarried());
    }

    @Test
    void getGroomUsualResidenceTest() {
        assertNull(marriageCertificateCommand.getGroomUsualResidence());
    }

    @Test
    void setGroomUsualResidenceTest() {
        marriageCertificateCommand.setGroomUsualResidence(place);
        assertEquals(place, marriageCertificateCommand.getGroomUsualResidence());
    }

    @Test
    void getBrideUsualResidenceTest() {
        assertNull(marriageCertificateCommand.getBrideUsualResidence());
    }

    @Test
    void setBrideUsualResidenceTest() {
        marriageCertificateCommand.setBrideUsualResidence(place);
        assertEquals(place, marriageCertificateCommand.getBrideUsualResidence());
    }


}