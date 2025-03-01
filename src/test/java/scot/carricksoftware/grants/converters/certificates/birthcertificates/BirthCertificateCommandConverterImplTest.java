/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

class BirthCertificateCommandConverterImplTest {

    final BirthCertificateCommandConverterImpl converter = new BirthCertificateCommandConverterImpl();
    BirthCertificateCommand source;

    @BeforeEach
    void setUp() {
        source = new BirthCertificateCommand();
    }

    @Test
    void convert() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();

        source.setId(id);
        source.setPerson(person);

        BirthCertificate target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(person, target.getPerson());
    }
}