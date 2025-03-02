/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.certificates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BirthCertificateServiceFindTest {

    BirthCertificateService birthCertificateService;

    @Mock
    BirthCertificateRepository birthCertificateRepositoryMock;

    @Mock
    BirthCertificateConverterImpl birthCertificateConverterImplMock;

    @Mock
    BirthCertificateCommandConverterImpl birthCertificateCommandConverterImplMock;

    @Before
    public void setUp() {
        birthCertificateService = new BirthCertificateServiceImpl(
                birthCertificateRepositoryMock,
                birthCertificateConverterImplMock,
                birthCertificateCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void findByIdTest() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        when(birthCertificateRepositoryMock.findById(id)).thenReturn(Optional.of(birthCertificate));
        assertEquals(birthCertificate, birthCertificateService.findById(id));
    }

    @Test
    public void findByIdNullTest() {
        Long id = GetRandomLong();
        when(birthCertificateRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(birthCertificateService.findById(id));
    }

    @Test
    public void findAllTest() {
        List<BirthCertificate> birthCertificateList = new ArrayList<>();
        birthCertificateList.add(GetRandomBirthCertificate());
        when(birthCertificateRepositoryMock.findAll()).thenReturn(birthCertificateList);
        assertEquals(birthCertificateList, birthCertificateService.findAll());
    }

}