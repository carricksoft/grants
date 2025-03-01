/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;


@SpringBootTest
class BaseCertificateTest {

    BaseCertificate baseCertificate;

    @BeforeEach
    void setUp() {
        baseCertificate = new BaseCertificate();
    }

    @Test
    void getPerson() {
        assertNull(baseCertificate.getPerson());
    }

    @Test
    void setPerson() {
        Person person = GetRandomPerson();
        baseCertificate.setPerson(person);
        assertEquals(person, baseCertificate.getPerson());
    }
}