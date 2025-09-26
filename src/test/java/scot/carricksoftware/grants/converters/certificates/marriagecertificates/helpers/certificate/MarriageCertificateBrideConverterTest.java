/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class MarriageCertificateBrideConverterTest {

    private MarriageCertificateBrideConverter converter;

    private MarriageCertificate source;
    private MarriageCertificateCommand target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateBrideConverterImpl();
        source = new MarriageCertificate();
        target = new MarriageCertificateCommandImpl();
    }

    @Test
    void convertTest() {
        source.setBride(GetRandomPerson());
        source.setBrideUsualResidence(GetRandomPlace());
        source.setBrideAge(GetRandomString());
        source.setBrideCondition(GetRandomString());
        source.setBrideFather(GetRandomPerson());
        source.setBrideFatherRank(GetRandomString());
        source.setBrideRank(GetRandomString());
        source.setBrideUntrackedFather(GetRandomString());
        source.setBrideUntrackedResidence(GetRandomString());
        source.setBrideUsualResidence(GetRandomPlace());

        converter.convert(source, target);

        assertEquals(source.getBride(), target.getBride());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());
        assertEquals(source.getBrideAge(), target.getBrideAge());
        assertEquals(source.getBrideCondition(), target.getBrideCondition());
        assertEquals(source.getBrideFather(), target.getBrideFather());
        assertEquals(source.getBrideFatherRank(), target.getBrideFatherRank());
        assertEquals(source.getBrideRank(), target.getBrideRank());
        assertEquals(source.getBrideUntrackedFather(), target.getBrideUntrackedFather());
        assertEquals(source.getBrideUntrackedResidence(), target.getBrideUntrackedResidence());
        assertEquals(source.getBrideUsualResidence(), target.getBrideUsualResidence());


    }

}