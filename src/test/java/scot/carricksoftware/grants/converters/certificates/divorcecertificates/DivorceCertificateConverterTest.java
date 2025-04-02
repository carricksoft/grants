/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.divorcecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class DivorceCertificateConverterTest {

    private DivorceCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DivorceCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Person firstParty = GetRandomPerson();
        Person secondParty = GetRandomPerson();
        DivorceCertificate source = new DivorceCertificate();

        source.setId(id);
        source.setFirstParty(firstParty);
        source.setSecondParty(secondParty);

        DivorceCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(firstParty, target.getFirstParty());
        assertEquals(secondParty, target.getSecondParty());
    }
}