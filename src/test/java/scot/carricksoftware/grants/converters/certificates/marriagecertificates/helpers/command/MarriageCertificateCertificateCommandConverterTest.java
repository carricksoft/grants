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
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class MarriageCertificateCertificateCommandConverterTest {

    private MarriageCertificateCertificateCommandConverter converter;
   
    private MarriageCertificateCommand source;
    private MarriageCertificate target;

    @BeforeEach
    void setUp() {
        converter = new MarriageCertificateCertificateCommandConverterImpl();
        source = new MarriageCertificateCommandImpl();
        target = new MarriageCertificate();
    }

    @Test
    void convertTest() {
        source.setId(GetRandomLong());
        source.setNumber(GetRandomString());
        source.setRegistrationAuthority(GetRandomOrganisation());
        source.setUntrackedWhereMarried(GetRandomString());
        source.setVolume(GetRandomString());
        source.setWhenMarried(GetRandomString());
        source.setWhereMarried(GetRandomPlace());

        converter.convert(source, target);

        assertEquals(source.getId(),target.getId());
        assertEquals(source.getNumber(),target.getNumber());
        assertEquals(source.getRegistrationAuthority(),target.getRegistrationAuthority());
        assertEquals(source.getUntrackedWhereMarried(),target.getUntrackedWhereMarried());
        assertEquals(source.getVolume(),target.getVolume());
        assertEquals(source.getWhenMarried(),target.getWhenMarried());
        assertEquals(source.getWhereMarried(),target.getWhereMarried());
    }

}