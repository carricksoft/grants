/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class BirthCertificatePlaceOfBirthTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    public void getMotherPlaceOfBirthTest() {
        assertNull(command.getMotherPlaceOfBirth());
    }

    @Test
    public void setMotherPlaceOfBirthTest() {
        String placeOfBirth = GetRandomString();
        command.setMotherPlaceOfBirth(placeOfBirth);
        assertEquals(placeOfBirth, command.getMotherPlaceOfBirth());
    }

    @Test
    public void getFatherPlaceOfBirthTest() {
        assertNull(command.getFatherPlaceOfBirth());
    }

    @Test
    public void setFatherPlaceOfBirthTest() {
        String placeOfBirth = GetRandomString();
        command.setFatherPlaceOfBirth(placeOfBirth);
        assertEquals(placeOfBirth, command.getFatherPlaceOfBirth());
    }
}