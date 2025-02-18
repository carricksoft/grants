/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.exceptions.GrantsException;

import static org.mockito.Mockito.verify;

@SpringBootTest
class DataLoaderTest {

    private DataLoader dataLoader;

    @Mock
    private DataLoadPersons dataLoadPersonsMock;

    @Mock
    private DataLoadPlaces dataLoadPlacesMock;

    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader(dataLoadPersonsMock, dataLoadPlacesMock);
    }

    @Test
    void delegationTest() throws GrantsException {
        dataLoader.run();
        verify(dataLoadPersonsMock).load();
        verify(dataLoadPlacesMock).load();
    }
}