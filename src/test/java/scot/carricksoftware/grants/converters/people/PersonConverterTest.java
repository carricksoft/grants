/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.text.PersonText;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class PersonConverterTest {


    private PersonConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String firstName = GetRandomString();
        String lastName = GetRandomString();
        Person source = new Person();
        String recordedYearOfBirth = GetRandomString();
        String certifiedYearOfBirth = GetRandomString();

        ArrayList<DivorceCertificate> divorceCertificates = new ArrayList<>();
        divorceCertificates.add(new DivorceCertificate());

        ArrayList<PersonImage> personImages = new ArrayList<>();
        personImages.add(new PersonImage());

        ArrayList<PersonText> personTexts = new ArrayList<>();
        personTexts.add(new PersonText());

        ArrayList<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(new CensusEntry());

        ArrayList<DeathCertificate> deathCertificates = new ArrayList<>();
        deathCertificates.add(new DeathCertificate());

        ArrayList<BirthCertificate> birthCertificates = new ArrayList<>();
        birthCertificates.add(new BirthCertificate());

        ArrayList<MarriageCertificate> marriageCertificates = new ArrayList<>();
        marriageCertificates.add(new MarriageCertificate());


        source.setId(id);
        source.setFirstName(firstName);
        source.setLastName(lastName);
        source.setRecordedYearOfBirth(recordedYearOfBirth);
        source.setCertifiedYearOfBirth(certifiedYearOfBirth);

        source.setDivorceCertificates(divorceCertificates);
        source.setPersonImages(personImages);
        source.setPersonTexts(personTexts);
        source.setCensusEntries(censusEntries);
        source.setDeathCertificates(deathCertificates);
        source.setBirthCertificates(birthCertificates);
        source.setMarriageCertificates(marriageCertificates);


        PersonCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(firstName, target.getFirstName());
        assertEquals(lastName, target.getLastName());
        assertEquals(recordedYearOfBirth, target.getRecordedYearOfBirth());
        assertEquals(certifiedYearOfBirth, target.getCertifiedYearOfBirth());

        assertEquals(divorceCertificates, target.getDivorceCertificates());
        assertEquals(personImages, target.getPersonImages());
        assertEquals(personTexts, target.getPersonTexts());
        assertEquals(censusEntries, target.getCensusEntries());
        assertEquals(deathCertificates, target.getDeathCertificates());
        assertEquals(birthCertificates, target.getBirthCertificates());
        assertEquals(marriageCertificates, target.getMarriageCertificates());

    }
}