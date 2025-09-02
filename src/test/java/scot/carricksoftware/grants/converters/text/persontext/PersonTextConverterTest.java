/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.text.PersonText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextConverterTest {

    private PersonTextConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonTextConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Person person = GetRandomPerson();
        Long order = GetRandomLong();
        Long level = GetRandomLong();
        String heading = GetRandomString();
        String content = GetRandomString();
        PersonText source = new PersonText();

        source.setId(Id);
        source.setPerson(person);
        source.setOrder(order);
        source.setLevel(level);
        source.setHeading(heading);
        source.setOrder(order);
        source.setContent(content);

        PersonTextCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(person, target.getPerson());
        assertEquals(order, target.getOrder());
        assertEquals(level, target.getLevel());
        assertEquals(heading, target.getHeading());
        assertEquals(content, target.getContent());
    }
}