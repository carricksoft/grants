/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class BirthCertificatePartThreeTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    public void getInformantTest() {
        assertNull(certificate.getInformant());
    }

    @Test
    public void setInformantTest() {
        Person informant = GetRandomPerson();
        certificate.setInformant(informant);
        assertEquals(informant, certificate.getInformant());
    }

    @Test
    public void getUntrackedInformantTest() {
        assertNull(certificate.getUntrackedInformant());
    }

    @Test
    public void setUntrackedInformantTest() {
        String untrackedInformant = GetRandomString();
        certificate.setUntrackedInformant(untrackedInformant);
        assertEquals(untrackedInformant, certificate.getUntrackedInformant());
    }

    @Test
    public void getInformantQualificationTest() {
        assertNull(certificate.getInformantQualification());
    }

    @Test
    public void setInformantQualificationTest() {
        String informantQualification = GetRandomString();
        certificate.setInformantQualification(informantQualification);
        assertEquals(informantQualification, certificate.getInformantQualification());
    }
}