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


    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader(dataLoadPlacesMock, dataLoadPeopleMock);
    }

    @Test
    void loadPlacesIsCalledTest() {
        dataLoader.run();
        verify(dataLoadPlacesMock).load();
    }
}