/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.death;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class DeathCertificateCommandPersonTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void getDeceasedTest() {
        assertNull(deathCertificateCommand.getDeceased());
    }

    @Test
    void setDeceasedTest() {
        Person deceased = GetRandomPerson();
        deathCertificateCommand.setDeceased(deceased);
        assertEquals(deceased, deathCertificateCommand.getDeceased());
    }

    @Test
    void getFatherTest() {
        assertNull(deathCertificateCommand.getFather());
    }

    @Test
    void setFatherTest() {
        Person father = GetRandomPerson();
        deathCertificateCommand.setFather(father);
        assertEquals(father, deathCertificateCommand.getFather());
    }

    @Test
    void getMotherTest() {
        assertNull(deathCertificateCommand.getMother());
    }

    @Test
    void setMotherTest() {
        Person mother = GetRandomPerson();
        deathCertificateCommand.setMother(mother);
        assertEquals(mother, deathCertificateCommand.getMother());
    }

    @Test
    void getInformantTest() {
        assertNull(deathCertificateCommand.getInformant());
    }

    @Test
    void setInformantTest() {
        Person informant = GetRandomPerson();
        deathCertificateCommand.setInformant(informant);
        assertEquals(informant, deathCertificateCommand.getInformant());
    }

    @Test
    void getSpouseTest() {
        assertNull(deathCertificateCommand.getSpouse());
    }

    @Test
    void setSpouseTest() {
        Person spouse = GetRandomPerson();
        deathCertificateCommand.setSpouse(spouse);
        assertEquals(spouse, deathCertificateCommand.getSpouse());
    }


}