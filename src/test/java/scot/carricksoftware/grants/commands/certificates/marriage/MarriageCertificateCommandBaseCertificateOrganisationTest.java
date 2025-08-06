/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


class MarriageCertificateCommandBaseCertificateOrganisationTest {

    private MarriageCertificateCommand command;
    private Organisation organisation;

    @BeforeEach
    void setUp() {
        command = new MarriageCertificateCommandImpl();
        organisation = GetRandomOrganisation();
    }

    @Test
    void getCertificateSourceTest() {
        assertNull(command.getCertificateSource());
    }

    @Test
    void setCertificateSourceTest() {
        command.setCertificateSource(organisation);
        assertEquals(organisation, command.getCertificateSource());
    }

    @Test
    void getCertificateTypeTest() {
        assertNull(command.getCertificateType());
    }

    @Test
    void setCertificateTypeTest() {
        command.setCertificateType(CertificateType.EXTRACT);
        assertEquals(CertificateType.EXTRACT, command.getCertificateType());
    }

    @Test
    void getRegistrationAuthorityTest() {
        assertNull(command.getRegistrationAuthority());
    }

    @Test
    void setRegistrationAuthorityTest() {
        command.setRegistrationAuthority(organisation);
        assertEquals(organisation, command.getRegistrationAuthority());
    }

}
    
