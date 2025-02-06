/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
        person.setFirstName("John");
        assertEquals("John", person.getFirstName());
    }

    @Test
    void getLastName() {
        assertNull(person.getLastName());
    }

    @Test
    void setLastName() {
        person.setLastName("Doe");
        assertEquals("Doe", person.getLastName());
    }
}