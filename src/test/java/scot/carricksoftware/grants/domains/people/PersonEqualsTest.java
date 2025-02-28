/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class PersonEqualsTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void nullTest() {
        assertNotEquals(null, person);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void wrongTypeTest() {
        assertNotEquals(person, GetRandomString());
    }

    @Test
    void equalsTest() {
        Person testPerson = new Person();
        person.setFirstName(GetRandomString());
        testPerson.setFirstName(person.getFirstName());
        person.setLastName(GetRandomString());
        testPerson.setLastName(person.getLastName());

        assertEquals(person, testPerson);
    }

    @Test
    void firstNameNotEqualTest() {
        Person testPerson = new Person();
        person.setFirstName(GetRandomString());
        testPerson.setFirstName("");

        person.setLastName(GetRandomString());
        testPerson.setLastName(person.getLastName());

        assertNotEquals(person, testPerson);
    }

    @Test
    void lastNameNotEqualTest() {
        Person testPerson = new Person();
        person.setLastName(GetRandomString());
        person.setLastName("");

        person.setFirstName(GetRandomString());
        testPerson.setFirstName(person.getFirstName());

        assertNotEquals(person, testPerson);
    }
}