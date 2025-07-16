/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class DeathCertificateCommandConverterPlaceTest {

    private DeathCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Place usualResidence = GetRandomPlace();
        Place whereDied = GetRandomPlace();

        DeathCertificateCommand source = new DeathCertificateCommandImpl();

        source.setUsualResidence(usualResidence);
        source.setWhereDied(whereDied);

        DeathCertificate target = converter.convert(source);

        assert target != null;

        assertEquals(usualResidence,target.getUsualResidence());
        assertEquals(whereDied,target.getWhereDied());

    }
}