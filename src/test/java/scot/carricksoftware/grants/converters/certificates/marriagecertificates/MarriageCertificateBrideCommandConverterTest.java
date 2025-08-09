/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateBrideCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateBrideCommandConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class MarriageCertificateBrideCommandConverterTest {

    private MarriageCertificateBrideCommandConverter converter;
   
    private MarriageCertificateCommand source;
    private MarriageCertificate target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateBrideCommandConverterImpl();
        source = new MarriageCertificateCommandImpl();
        target = new MarriageCertificate();
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

        assertEquals(source.getBride(),target.getBride());
        assertEquals(source.getBrideUsualResidence(),target.getBrideUsualResidence());
        assertEquals(source.getBrideAge(),target.getBrideAge());
        assertEquals(source.getBrideCondition(),target.getBrideCondition());
        assertEquals(source.getBrideFather(),target.getBrideFather());
        assertEquals(source.getBrideFatherRank(),target.getBrideFatherRank());
        assertEquals(source.getBrideRank(),target.getBrideRank());
        assertEquals(source.getBrideUntrackedFather(),target.getBrideUntrackedFather());
        assertEquals(source.getBrideUntrackedResidence(),target.getBrideUntrackedResidence());
        assertEquals(source.getBrideUsualResidence(),target.getBrideUsualResidence());
        
  

    }

}