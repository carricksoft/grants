/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class BirthCertificateCommandInformantTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    public void getInformantTest() {
        assertNull(command.getInformant());
    }

    @Test
    public void setInformantTest() {
        Person informant = GetRandomPerson();
        command.setInformant(informant);
        assertEquals(informant, command.getInformant());
    }

    @Test
    public void getUntrackedInformantTest() {
        assertNull(command.getUntrackedInformant());
    }

    @Test
    public void setUntrackedInformantTest() {
        String untrackedInformant = GetRandomString();
        command.setUntrackedInformant(untrackedInformant);
        assertEquals(untrackedInformant, command.getUntrackedInformant());
    }

    @Test
    public void getInformantQualificationTest() {
        assertNull(command.getInformantQualification());
    }

    @Test
    public void setInformantQualificationTest() {
        String informantQualification = GetRandomString();
        command.setInformantQualification(informantQualification);
        assertEquals(informantQualification, command.getInformantQualification());
    }

}