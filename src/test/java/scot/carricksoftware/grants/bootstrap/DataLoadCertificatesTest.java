/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataLoadCertificatesTest {

    @Mock
    private DataLoadBirthCertificates dataLoadBirthCertificatesMock;

    @Mock
    private DataLoadDeathCertificates dataLoadDeathCertificatesMock;

    @Mock
    private DataLoadMarriageCertificates dataLoadMarriageCertificatesMock;

    @BeforeEach
    void setUp() {
        DataLoadCertificates dataLoadCertificates = new DataLoadCertificates(dataLoadBirthCertificatesMock, dataLoadDeathCertificatesMock, dataLoadMarriageCertificatesMock);
        dataLoadCertificates.load();
    }

    @Test
    void birthCertificatesAreLoaded() {
        verify(dataLoadBirthCertificatesMock).load();
    }

    @Test
    void deathCertificatesAreLoaded() {
        verify(dataLoadDeathCertificatesMock).load();
    }

    @Test
    void marriageCertificatesAreLoaded() {
        verify(dataLoadMarriageCertificatesMock).load();
    }


}