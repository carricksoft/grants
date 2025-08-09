/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class MarriageCertificateGroomConverterCommandTest {

    private MarriageCertificateGroomCommandConverter converter;
   
    private MarriageCertificateCommand source;
    private MarriageCertificate target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateGroomCommandConverterImpl();
        source = new MarriageCertificateCommandImpl();
        target = new MarriageCertificate();
    }

    @Test
    void convertTest() {
        source.setGroom(GetRandomPerson());
        source.setGroomUsualResidence(GetRandomPlace());
        source.setGroomAge(GetRandomString());
        source.setGroomCondition(GetRandomString());
        source.setGroomFather(GetRandomPerson());
        source.setGroomFatherRank(GetRandomString());
        source.setGroomRank(GetRandomString());
        source.setGroomUntrackedFather(GetRandomString());
        source.setGroomUntrackedResidence(GetRandomString());
        source.setGroomUsualResidence(GetRandomPlace());

        converter.convert(source, target);

        assertEquals(source.getGroom(),target.getGroom());
        assertEquals(source.getGroomUsualResidence(),target.getGroomUsualResidence());
        assertEquals(source.getGroomAge(),target.getGroomAge());
        assertEquals(source.getGroomCondition(),target.getGroomCondition());
        assertEquals(source.getGroomFather(),target.getGroomFather());
        assertEquals(source.getGroomFatherRank(),target.getGroomFatherRank());
        assertEquals(source.getGroomRank(),target.getGroomRank());
        assertEquals(source.getGroomUntrackedFather(),target.getGroomUntrackedFather());
        assertEquals(source.getGroomUntrackedResidence(),target.getGroomUntrackedResidence());
        assertEquals(source.getGroomUsualResidence(),target.getGroomUsualResidence());
        
  

    }

}