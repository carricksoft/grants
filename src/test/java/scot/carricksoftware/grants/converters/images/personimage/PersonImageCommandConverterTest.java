/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonImageCommandConverterTest {

    private PersonImageCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonImageCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Person person = GetRandomPerson();
        Image image = new Image();
        String level = GetRandomString();
        String order = GetRandomString();
        String caption = GetRandomString();
        String height = GetRandomString();
        String width = GetRandomString();


        PersonImageCommand source = new PersonImageCommandImpl();

        source.setPerson(person);
        source.setId(Id);
        source.setImage(image);
        source.setLevel(level);
        source.setOrder(order);
        source.setCaption(caption);
        source.setHeight(height);
        source.setWidth(width);


        PersonImage target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(person, target.getPerson());
        assertEquals(image, target.getImage());
        assertEquals(level, target.getLevel());
        assertEquals(order, target.getOrder());
        assertEquals(caption, target.getCaption());
        assertEquals(height, target.getHeight());
        assertEquals(width, target.getWidth());
    }
}