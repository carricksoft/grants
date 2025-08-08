/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseStringImpl;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CapitaliseBirthCertificatesPartTwoTest {

    private CapitaliseBirthCertificate capitaliseBirthCertificate;

    @Mock
    private CapitaliseStringImpl capitaliseStringMock;

    private BirthCertificateCommand birthCertificateCommand;

    @BeforeEach
    void setUp() {
        capitaliseBirthCertificate = new CapitaliseBirthCertificateImpl(capitaliseStringMock);
        birthCertificateCommand = new BirthCertificateCommandImpl();
        when(capitaliseStringMock.capitalise(any())).thenReturn("Lower");
    }


    @Test
    void whenBornTest() {
        birthCertificateCommand.setWhenBorn("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getWhenBorn());
    }

    @Test
    void certificateNumberTest() {
        birthCertificateCommand.setCertificateNumber("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getCertificateNumber());
    }

    @Test
    void whereRegisteredTest() {
        birthCertificateCommand.setWhereRegistered("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getWhereRegistered());
    }

    @Test
    void fatherRankTest() {
        birthCertificateCommand.setFatherRank("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getFatherRank());
    }

    @Test
    void dateAndPlaceOfMarriageTest() {
        birthCertificateCommand.setDateAndPlaceOfMarriage("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getDateAndPlaceOfMarriage());
    }

    @Test
    void unformattedFatherUsualResidenceTest() {
        birthCertificateCommand.setUntrackedFatherUsualResidence("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getUntrackedFatherUsualResidence());
    }

    @Test
    void informantResidenceTest() {
        birthCertificateCommand.setInformantResidence("lower");
        capitaliseBirthCertificate.capitalise(birthCertificateCommand);
        assertEquals("Lower", birthCertificateCommand.getInformantResidence());
    }


}