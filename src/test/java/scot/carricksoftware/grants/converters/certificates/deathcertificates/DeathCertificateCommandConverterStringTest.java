/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class DeathCertificateCommandConverterStringTest {

    private DeathCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        String age = GetRandomString();
        String causeOfDeath = GetRandomString();
        String fatherOccupation = GetRandomString();
        String informantAddress = GetRandomString();
        String informantQualification = GetRandomString();
        String maritalStatus = GetRandomString();
        String motherOccupation = GetRandomString();
        String occupation  = GetRandomString();
        String spouseOccupation = GetRandomString();
        String untrackedFather = GetRandomString();
        String untrackedInformant = GetRandomString();
        String untrackedMother = GetRandomString();
        String untrackedSpouse = GetRandomString();
        String untrackedUsualResidence = GetRandomString();
        String untrackedWhereDied = GetRandomString();
        String whenBorn = GetRandomString();
        String whenDied = GetRandomString();
        String whenRegistered = GetRandomString();
        String whereRegistered = GetRandomString();
        
        DeathCertificateCommand source = new DeathCertificateCommandImpl();

        source.setAge(age);
        source.setCauseOfDeath(causeOfDeath);
        source.setFatherOccupation(fatherOccupation);
        source.setInformantAddress(informantAddress);
        source.setInformantQualification(informantQualification);
        source.setMaritalStatus(maritalStatus);
        source.setMotherOccupation(motherOccupation);
        source.setOccupation(occupation);
        source.setSpouseOccupation(spouseOccupation);
        source.setUntrackedFather(untrackedFather);
        source.setUntrackedInformant(untrackedInformant);
        source.setUntrackedMother(untrackedMother);
        source.setUntrackedSpouse(untrackedSpouse);
        source.setUntrackedUsualResidence(untrackedUsualResidence);
        source.setUntrackedWhereDied(untrackedWhereDied);
        source.setWhenBorn(whenBorn);
        source.setWhenDied(whenDied);
        source.setWhenRegistered(whenRegistered);
        source.setWhereRegistered(whereRegistered);
        
        DeathCertificate target = converter.convert(source);

        assert target != null;

        assertEquals(age,target.getAge());
        assertEquals(causeOfDeath,target.getCauseOfDeath());
        assertEquals(fatherOccupation,target.getFatherOccupation());
        assertEquals(informantAddress,target.getInformantAddress());
        assertEquals(informantQualification,target.getInformantQualification());
        assertEquals(maritalStatus,target.getMaritalStatus());
        assertEquals(motherOccupation,target.getMotherOccupation());
        assertEquals(occupation,target.getOccupation());
        assertEquals(spouseOccupation,target.getSpouseOccupation());
        assertEquals(untrackedFather,target.getUntrackedFather());
        assertEquals(untrackedInformant,target.getUntrackedInformant());
        assertEquals(untrackedMother,target.getUntrackedMother());
        assertEquals(untrackedSpouse,target.getUntrackedSpouse());
        assertEquals(untrackedUsualResidence,target.getUntrackedUsualResidence());
        assertEquals(untrackedWhereDied,target.getUntrackedWhereDied());
        assertEquals(whenBorn,target.getWhenBorn());
        assertEquals(whenDied,target.getWhenDied());
        assertEquals(whenRegistered,target.getWhenRegistered());
        assertEquals(whereRegistered,target.getWhereRegistered());
        
    }
}