/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.certificates;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;


@SpringBootTest
public class BirthCertificateCommandTest {

    BirthCertificateCommand birthCertificateCommand;

    @Before
    public void setUp() {
        birthCertificateCommand = new BirthCertificateCommand();
    }


    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        birthCertificateCommand.setId(id);
        assertEquals(id, birthCertificateCommand.getId());
    }

    @Test
    public void getPersonTest() {
        assertNull(birthCertificateCommand.getPerson());
    }

    @Test
    public void setPersonTest() {
        Person person = GetRandomPerson();
        birthCertificateCommand.setPerson(person);
        assertEquals(person, birthCertificateCommand.getPerson());
    }
}