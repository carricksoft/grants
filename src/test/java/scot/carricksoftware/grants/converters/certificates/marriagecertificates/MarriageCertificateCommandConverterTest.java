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

        source.setCertificateDate(GetRandomString());
        source.setCertificateNumber(GetRandomString());
        source.setCertificateSource(GetRandomOrganisation());
        source.setCertificateType(CertificateType.EXTRACT);
        source.setFirstWitness(GetRandomPerson());
        source.setGroom(GetRandomPerson());
        source.setGroomAge(GetRandomString());
        source.setGroomCondition(GetRandomString());
        source.setGroomFather(GetRandomPerson());
        source.setGroomFatherRank(GetRandomString());
        source.setGroomRank(GetRandomString());
        source.setGroomUntrackedFather(GetRandomString());
        source.setGroomUntrackedResidence(GetRandomString());
        source.setGroomUsualResidence(GetRandomPlace());
        source.setId(GetRandomLong());
        source.setNumber(GetRandomString());
        source.setRegistrationAuthority(GetRandomOrganisation());
        source.setSecondWitness(GetRandomPerson());
        source.setUntrackedFirstWitness(GetRandomString());
        source.setUntrackedSecondWitness(GetRandomString());
        source.setUntrackedWhereMarried(GetRandomString());
        source.setVolume(GetRandomString());
        source.setWhenMarried(GetRandomString());
        source.setWhereMarried(GetRandomPlace());


        MarriageCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(source.getCertificateDate(), target.getCertificateDate());
        assertEquals(source.getCertificateNumber(), target.getCertificateNumber());
        assertEquals(source.getCertificateSource(), target.getCertificateSource());
        assertEquals(source.getCertificateType(), target.getCertificateType());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getFirstWitness(), target.getFirstWitness());
        assertEquals(source.getGroom(), target.getGroom());
        assertEquals(source.getGroomAge(), target.getGroomAge());
        assertEquals(source.getGroomCondition(), target.getGroomCondition());
        assertEquals(source.getGroomFather(), target.getGroomFather());
        assertEquals(source.getGroomFatherRank(), target.getGroomFatherRank());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getGroomRank(), target.getGroomRank());
        assertEquals(source.getGroomUntrackedFather(), target.getGroomUntrackedFather());
        assertEquals(source.getGroomUntrackedResidence(), target.getGroomUntrackedResidence());
        assertEquals(source.getGroomUsualResidence(), target.getGroomUsualResidence());
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getNumber(), target.getNumber());
        assertEquals(source.getRegistrationAuthority(), target.getRegistrationAuthority());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getSecondWitness(), target.getSecondWitness());
        assertEquals(source.getUntrackedFirstWitness(), target.getUntrackedFirstWitness());
        assertEquals(source.getUntrackedSecondWitness(), target.getUntrackedSecondWitness());
        assertEquals(source.getUntrackedWhereMarried(), target.getUntrackedWhereMarried());
        assertEquals(source.getVolume(), target.getVolume());
        assertEquals(source.getWhenMarried(), target.getWhenMarried());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());
        assertEquals(source.getWhereMarried(), target.getWhereMarried());


    }
}