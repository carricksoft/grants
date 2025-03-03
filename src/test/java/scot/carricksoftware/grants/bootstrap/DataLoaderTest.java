package scot.carricksoftware.grants.bootstrap;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataLoaderTest {

    private DataLoader dataLoader;

    @Mock
    DataLoadPersons dataLoadPersonsMock;

    @Mock
    DataLoadPlaces dataLoadPlacesMock;

    @Mock
    DataLoadCensus dataLoadCensusMock;


    @Mock
    DataLoadCertificates dataLoadCertificatesMock;

    @Before
    public void setUp() {
        dataLoader = new DataLoader(dataLoadPersonsMock,
                dataLoadPlacesMock,
                dataLoadCensusMock,
                dataLoadCertificatesMock);
    }

    @Test
    public void dataLoadPersonsIsCalled() {
        dataLoader.run();
        verify(dataLoadPersonsMock).load();
    }

    @Test
    public void dataLoadPlacesIsCalled() {
        dataLoader.run();
        verify(dataLoadPlacesMock).load();
    }

    @Test
    public void dataLoadCensusIsCalled() {
        dataLoader.run();
        verify(dataLoadPlacesMock).load();
    }

    @Test
    public void dataLoadCertificatesIsCalled() {
        dataLoader.run();
        verify(dataLoadCertificatesMock).load();
    }
}