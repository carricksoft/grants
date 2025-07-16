/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Organisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

class BirthCertificateCommandRegistrationTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    void getRegistrationAuthorityTest() {
        assertNull(command.getRegistrationAuthority());
    }

    @Test
    void setRegistrationAuthorityTest() {
        Organisation registrationAuthority = GetRandomOrganisation();
        command.setRegistrationAuthority(registrationAuthority);
        assertEquals(registrationAuthority, command.getRegistrationAuthority());
    }

    @Test
    void getVolumeTest() {
        assertNull(command.getVolume());
    }

    @Test
    void setVolumeTest() {
        String volume = GetRandomString();
        command.setVolume(volume);
        assertEquals(volume, command.getVolume());
    }

    @Test
    void getNumberTest() {
        assertNull(command.getNumber());
    }

    @Test
    void setNumberTest() {
        String number = GetRandomString();
        command.setNumber(number);
        assertEquals(number, command.getNumber());
    }

}