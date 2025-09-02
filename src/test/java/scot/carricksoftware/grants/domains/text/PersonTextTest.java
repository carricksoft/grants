/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextTest {

    private PersonText personText;

    @BeforeEach
    void setUp() {
        personText = new PersonText();
    }

    @Test
    void getIdTest() {
        Long id = GetRandomLong();
        personText.setId(id);
        assertNotNull(personText.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        personText.setId(id);
        assertEquals(id, personText.getId());
    }

    @Test
    void getPersonTest() {
        assertNull(personText.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        personText.setPerson(person);
        assertEquals(person, personText.getPerson());
    }

    @Test
    void getLevelTest() {
        assertNull(personText.getLevel());
    }

    @Test
    void setLevelTest() {
        Long level = GetRandomLong();
        personText.setLevel(level);
        assertEquals(level, personText.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(personText.getOrder());
    }

    @Test
    void setOrderTest() {
        Long order = GetRandomLong();
        personText.setOrder(order);
        assertEquals(order, personText.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(personText.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        personText.setHeading(heading);
        assertEquals(heading, personText.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(personText.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        personText.setContent(content);
        assertEquals(content, personText.getContent());
    }


}