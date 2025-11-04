/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonBaseTextCommandTest {

    private PersonTextCommand personTextCommand;

    @BeforeEach
    void setUp() {
        personTextCommand = new PersonTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(personTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        personTextCommand.setId(id);
        assertEquals(id, personTextCommand.getId());
    }

    @Test
    void getPersonTest() {
        assertNull(personTextCommand.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        personTextCommand.setPerson(person);
        assertEquals(person, personTextCommand.getPerson());
    }

    @Test
    void getLevelTest() {
        assertNull(personTextCommand.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        personTextCommand.setLevel(level);
        assertEquals(level, personTextCommand.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(personTextCommand.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        personTextCommand.setOrder(order);
        assertEquals(order, personTextCommand.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(personTextCommand.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        personTextCommand.setHeading(heading);
        assertEquals(heading, personTextCommand.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(personTextCommand.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        personTextCommand.setContent(content);
        assertEquals(content, personTextCommand.getContent());
    }


}