/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverter;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class DeathCertificateConverterPlaceTest {

    private DeathCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Place usualResidence = GetRandomPlace();
        Place whereDied = GetRandomPlace();

        DeathCertificate source = new DeathCertificate();

        source.setUsualResidence(usualResidence);
        source.setWhereDied(whereDied);

        DeathCertificateCommand target = converter.convert(source);

        assert target != null;

        assertEquals(usualResidence,target.getUsualResidence());
        assertEquals(whereDied,target.getWhereDied());

    }
}