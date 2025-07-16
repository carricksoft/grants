/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverter;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class DeathCertificateConverterPersonTest {

    private DeathCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        Person father = GetRandomPerson();
        Person informant = GetRandomPerson();
        Person mother = GetRandomPerson();
        Person spouse = GetRandomPerson();

        DeathCertificate source = new DeathCertificate();

        source.setId(id);
        source.setDeceased(person);
        source.setFather(father);
        source.setInformant(informant);
        source.setMother(mother);
        source.setSpouse(spouse);

        DeathCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id,target.getId());
        assertEquals(person,target.getDeceased());
        assertEquals(father,target.getFather());
        assertEquals(informant,target.getInformant());
        assertEquals(mother,target.getMother());
        assertEquals(spouse,target.getSpouse());
    }
}