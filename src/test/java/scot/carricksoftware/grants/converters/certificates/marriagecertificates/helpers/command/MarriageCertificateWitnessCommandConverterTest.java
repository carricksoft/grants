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

class MarriageCertificateWitnessCommandConverterTest {

    private MarriageCertificateWitnessCommandConverter converter;
   
    private MarriageCertificateCommand source;
    private MarriageCertificate target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateWitnessCommandConverterImpl();
        source = new MarriageCertificateCommandImpl();
        target = new MarriageCertificate();
    }

    @Test
    void convertTest() {
        source.setFirstWitness(GetRandomPerson());
        source.setSecondWitness(GetRandomPerson());
        source.setUntrackedFirstWitness(GetRandomString());
        source.setUntrackedSecondWitness(GetRandomString());

        converter.convert(source, target);

        assertEquals(source.getFirstWitness(),target.getFirstWitness());
        assertEquals(source.getSecondWitness(),target.getSecondWitness());
        assertEquals(source.getUntrackedFirstWitness(),target.getUntrackedFirstWitness());
        assertEquals(source.getUntrackedSecondWitness(),target.getUntrackedSecondWitness());
    }

}