/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.repositories.certificates.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
class BirthCertificateServiceTest {

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

    @Mock
    Page<BirthCertificate> pageMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    void deleteByIdTest() {
        Long id = GetRandomLong();
        birthCertificateService.deleteById(id);
        verify(birthCertificateRepositoryMock).deleteById(id);
    }

    @Test
    void CountTest() {
        long result = GetRandomLong();
        when(birthCertificateRepositoryMock.count()).thenReturn(result);
        assertEquals(result, birthCertificateService.count());
    }

    @Test
    void getPagedBirthCertificateEntriesTest() {
        List<BirthCertificate> result = new ArrayList<>();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        result.add(birthCertificate);
        when(pageMock.getContent()).thenReturn(result);
        when(birthCertificateRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, birthCertificateService.getPagedCertificates(0));
    }


}