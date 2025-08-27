/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class DivorceCertificateCommandPersonTest {

    private DivorceCertificateCommand command;

    private Person person;

    @BeforeEach
    void setUp() {
        command = new DivorceCertificateCommandImpl();
        person = GetRandomPerson();
    }

    @Test
    public void getFirstPartyTest() {
        assertNull(command.getId());
    }

    @Test
    public void setFirstPartyTest() {
        command.setFirstParty(person);
        assertEquals(person, command.getFirstParty());
    }

    @Test
    public void getSecondPartyTest() {
        assertNull(command.getSecondParty());
    }

    @Test
    public void setSecondPartyTest() {
        command.setSecondParty(person);
        assertEquals(person, command.getSecondParty());
    }

}