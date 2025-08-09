/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateCommandConverterTest {

    private MarriageCertificateCommandConverter converter;

    @Mock
    private MarriageCertificateBrideCommandConverter marriageCertificateBrideConverterMock;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateCommandConverterImpl(marriageCertificateBrideConverterMock);
    }

    @Test
    void convertTest() {

        MarriageCertificateCommand source = new MarriageCertificateCommandImpl();

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
        source.setGroomFatherRank(GetRandomString());
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
        source.setCertificateNumber(GetRandomString());
        source.setCertificateType(CertificateType.EXTRACT);
        source.setCertificateSource(GetRandomOrganisation());
        source.setCertificateDate(GetRandomString());
        source.setRegistrationAuthority(GetRandomOrganisation());
        source.setVolume(GetRandomString());
        source.setNumber(GetRandomString());


        MarriageCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getBride(), target.getBride());
        assertEquals(source.getGroom(), target.getGroom());
        assertEquals(source.getGroomUntrackedResidence(), target.getGroomUntrackedResidence());
        assertEquals(source.getBrideUntrackedResidence(), target.getBrideUntrackedResidence());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());
        assertEquals(source.getGroomUsualResidence(), target.getGroomUsualResidence());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());
        assertEquals(source.getGroomFather(), target.getGroomFather());
        assertEquals(source.getBrideFather(), target.getBrideFather());
        assertEquals(source.getGroomUntrackedFather(), target.getGroomUntrackedFather());
        assertEquals(source.getBrideUntrackedFather(), target.getBrideUntrackedFather());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getBrideRank(), target.getBrideRank());
        assertEquals(source.getBrideFatherRank(), target.getBrideFatherRank());
        assertEquals(source.getGroomFatherRank(), target.getGroomFatherRank());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getWhenMarried(), target.getWhenMarried());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());
        assertEquals(source.getUntrackedWhereMarried(), target.getUntrackedWhereMarried());
        assertEquals(source.getGroomAge(), target.getGroomAge());
        assertEquals(source.getBrideAge(), target.getBrideAge());
        assertEquals(source.getGroomCondition(), target.getGroomCondition());
        assertEquals(source.getBrideCondition(), target.getBrideCondition());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getBrideRank(), target.getBrideRank());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getUntrackedFirstWitness(), target.getUntrackedFirstWitness());
        assertEquals(source.getUntrackedSecondWitness(), target.getUntrackedSecondWitness());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());

        assertEquals(source.getCertificateNumber(), target.getCertificateNumber());
        assertEquals(source.getCertificateType(), target.getCertificateType());
        assertEquals(source.getCertificateSource(), target.getCertificateSource());
        assertEquals(source.getCertificateDate(), target.getCertificateDate());
        assertEquals(source.getRegistrationAuthority(), target.getRegistrationAuthority());
        assertEquals(source.getVolume(), target.getVolume());
        assertEquals(source.getNumber(), target.getNumber());


    }
}