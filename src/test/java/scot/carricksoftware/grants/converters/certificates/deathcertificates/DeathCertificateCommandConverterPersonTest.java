/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class DeathCertificateCommandConverterPersonTest {

    private DeathCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        Person father = GetRandomPerson();
        Person informant = GetRandomPerson();
        Person mother = GetRandomPerson();
        Person spouse = GetRandomPerson();

        DeathCertificateCommand source = new DeathCertificateCommandImpl();

        source.setId(id);
        source.setDeceased(person);
        source.setFather(father);
        source.setInformant(informant);
        source.setMother(mother);
        source.setSpouse(spouse);

        DeathCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(id,target.getId());
        assertEquals(person,target.getDeceased());
        assertEquals(father,target.getFather());
        assertEquals(informant,target.getInformant());
        assertEquals(mother,target.getMother());
        assertEquals(spouse,target.getSpouse());

    }
}