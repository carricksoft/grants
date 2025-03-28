/*
 * Copyright (c) Andrew Grant of Carrick Software 12/03/2025, 17:46. All rights reserved.
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
class DataLoaderTest {

    private DataLoader dataLoader;

    @Mock
    private DataLoadPlaces dataLoadPlacesMock;

    @Mock
    private DataLoadPeople dataLoadPeopleMock;

    @Mock
    private DataLoadCensus dataLoadCensusMock;

    @Mock
    private DataLoadCertificates dataLoadCertificatesMock;

    @Mock
    private DataLoadTwoPartyCertificates dataLoadTwoPartyCertificates;

    @Mock
    private DataLoadImages dataLoadImagesMock;


    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader(dataLoadPlacesMock,
                dataLoadPeopleMock,
                dataLoadCensusMock,
                dataLoadCertificatesMock,
                dataLoadTwoPartyCertificates,
                dataLoadImagesMock);
    }

    @Test
    void loadPlacesIsCalledTest() {
        dataLoader.run();
        verify(dataLoadPlacesMock).load();
    }

    @Test
    void loadPeopleIsCalledTest() {
        dataLoader.run();
        verify(dataLoadPeopleMock).load();
    }

    @Test
    void loadCensusIsCalledTest() {
        dataLoader.run();
        verify(dataLoadCensusMock).load();
    }

    @Test
    void loadCertificatesIsCalledTest() {
        dataLoader.run();
        verify(dataLoadCertificatesMock).load();
    }

    @Test
    void loadCertificatesTwoPartyIsCalledTest() {
        dataLoader.run();
        verify(dataLoadTwoPartyCertificates).load();
    }

    @Test
    void loadCertificatesImagesIsCalledTest() {
        dataLoader.run();
        verify(dataLoadImagesMock).load();
    }
}