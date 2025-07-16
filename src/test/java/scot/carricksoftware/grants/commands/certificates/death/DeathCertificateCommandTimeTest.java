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


class DeathCertificateCommandTimeTest {

    private DeathCertificateCommand deathCertificateCommand;

    @BeforeEach
    void setUp() {
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }


    @Test
    void getWhenBornTest() {
        assertNull(deathCertificateCommand.getWhenBorn());
    }

    @Test
    void setWhenBornTest() {
        String whenBorn = GetRandomString();
        deathCertificateCommand.setWhenBorn(whenBorn);
        assertEquals(whenBorn, deathCertificateCommand.getWhenBorn());
    }

    @Test
    void getAgeTest() {
        assertNull(deathCertificateCommand.getAge());
    }

    @Test
    void setAgeTest() {
        String age = GetRandomString();
        deathCertificateCommand.setAge(age);
        assertEquals(age, deathCertificateCommand.getAge());
    }

    @Test
    void getWhenDiedTest() {
        assertNull(deathCertificateCommand.getWhenDied());
    }

    @Test
    void setWhenDiedTest() {
        String whenDied = GetRandomString();
        deathCertificateCommand.setWhenDied(whenDied);
        assertEquals(whenDied, deathCertificateCommand.getWhenDied());
    }

    @Test
    void getWhenRegistered() {
        assertNull(deathCertificateCommand.getWhenRegistered());
    }

    @Test
    void setWhenRegisteredTest() {
        String whenRegistered = GetRandomString();
        deathCertificateCommand.setWhenRegistered(whenRegistered);
        assertEquals(whenRegistered, deathCertificateCommand.getWhenRegistered());
    }

}