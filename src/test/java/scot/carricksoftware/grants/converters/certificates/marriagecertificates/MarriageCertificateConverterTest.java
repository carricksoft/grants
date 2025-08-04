/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class MarriageCertificateConverterTest {

    private MarriageCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        MarriageCertificate source = new MarriageCertificate();

        source.setId(GetRandomLong());
        source.setBride(GetRandomPerson());
        source.setGroom(GetRandomPerson());
        source.setGroomUsualResidence(GetRandomPlace());
        source.setBrideUsualResidence(GetRandomPlace());
        source.setGroomUntrackedResidence(GetRandomString());
        source.setBrideUntrackedResidence(GetRandomString());
        source.setGroomFather(GetRandomPerson());
        source.setBrideFather(GetRandomPerson());
        source.setGroomUntrackedFather(GetRandomString());
        source.setBrideUntrackedFather(GetRandomString());
        source.setBrideFatherRank(GetRandomString());
        source.setFirstWitness(GetRandomPerson());
        source.setSecondWitness(GetRandomPerson());
        source.setUntrackedFirstWitness(GetRandomString());
        source.setUntrackedSecondWitness(GetRandomString());
        source.setWhenMarried(GetRandomString());
        source.setWhereMarried(GetRandomPlace());
        source.setUntrackedWhereMarried(GetRandomString());
        source.setGroomAge(GetRandomString());
        source.setBrideAge(GetRandomString());
        source.setGroomCondition(GetRandomString());
        source.setBrideCondition(GetRandomString());
        source.setGroomRank(GetRandomString());
        source.setBrideRank(GetRandomString());

        MarriageCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getBride(), target.getBride());
        assertEquals(source.getGroom(), target.getGroom());
        assertEquals(source.getGroomUsualResidence(), target.getGroomUsualResidence());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());
        assertEquals(source.getGroomFather(), target.getGroomFather());
        assertEquals(source.getBrideFather(), target.getBrideFather());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getBrideRank(), target.getBrideRank());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());
        assertEquals(source.getGroomAge(), target.getGroomAge());
        assertEquals(source.getBrideAge(), target.getBrideAge());
        assertEquals(source.getGroomCondition(), target.getGroomCondition());
        assertEquals(source.getBrideCondition(), target.getBrideCondition());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getBrideRank(), target.getBrideRank());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());


    }
}