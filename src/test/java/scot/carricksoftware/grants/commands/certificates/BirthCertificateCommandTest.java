/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

class BirthCertificateCommandTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    void getNewBornTest() {
        assertNull(command.getId());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        command.setNewBorn(person);
        assertEquals(person, command.getNewBorn());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(command.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        command.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, command.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(command.getCertificateDate());
    }

    @Test
    void setCertificateDateNullTest() {
        String certificateDate = GetRandomString();
        command.setCertificateDate(certificateDate);
        assertEquals(certificateDate, command.getCertificateDate());
    }

    @Test
    void setCertificateDateEmptyTest() {
        String certificateDate = GetRandomString();
        command.setCertificateDate(certificateDate);
        assertEquals(certificateDate, command.getCertificateDate());
    }

    @Test
    void getCertificateSourceTest() {
        Organisation certificateSource = GetRandomOrganisation();
        command.setCertificateSource(certificateSource);
        assertEquals(certificateSource, command.getCertificateSource());
    }

    @Test
    void getCertificateTypeTest() {
        assertNull(command.getCertificateType());
    }

    @Test
    void setCertificateTypeTest() {
        CertificateType certificateType = CertificateType.EXTRACT;
        command.setCertificateType(certificateType);
        assertEquals(certificateType, command.getCertificateType());
    }
}