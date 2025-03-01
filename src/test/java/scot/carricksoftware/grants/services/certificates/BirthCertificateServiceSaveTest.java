/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;

@SpringBootTest
class BirthCertificateServiceSaveTest {

    BirthCertificateService birthCertificateService;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @Mock
    BirthCertificateConverterImpl birthCertificateConverterImplMock;

    @Mock
    BirthCertificateCommandConverterImpl birthCertificateCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(birthCertificateRepositoryMock,
                birthCertificateConverterImplMock,
                birthCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        BirthCertificate birthCertificate = new BirthCertificate();
        when(birthCertificateRepositoryMock.save(birthCertificate)).thenReturn(birthCertificate);
        assertEquals(birthCertificate, birthCertificateService.save(birthCertificate));
    }

    @Test
    void saveBirthCertificateCommandTest() {
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommand();
        when(birthCertificateCommandConverterImplMock.convert(birthCertificateCommand)).thenReturn(birthCertificate);
        when(birthCertificateRepositoryMock.save(birthCertificate)).thenReturn(birthCertificate);
        when(birthCertificateConverterImplMock.convert((birthCertificate))).thenReturn(birthCertificateCommand);

        assertEquals(birthCertificateCommand, birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand));
    }


}