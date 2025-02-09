/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstName() {
        assertNull(person.getFirstName());
    }

    @Test
    void setFirstName() {
        String name = GetRandomString();
        person.setFirstName(name);
        assertEquals(name, person.getFirstName());
    }

    @Test
    void getLastName() {
        assertNull(person.getLastName());
    }

    @Test
    void setLastName() {
        String name = GetRandomString();
        person.setLastName(name);
        assertEquals(name, person.getLastName());
    }

    @Test
    void toStringTest() {
        person.setLastName(GetRandomString());
        person.setFirstName(GetRandomString());
        assertEquals(person.getLastName() + ", " + person.getFirstName(), person.toString());
    }
}