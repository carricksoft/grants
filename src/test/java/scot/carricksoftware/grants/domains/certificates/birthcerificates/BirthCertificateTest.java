package scot.carricksoftware.grants.domains.certificates.birthcerificates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BirthCertificateTest {


    private BirthCertificate birthCertificate;


    @Before
    public void setUp() {
        birthCertificate = new BirthCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(birthCertificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        birthCertificate.setId(id);
        assertEquals(id, birthCertificate.getId());
    }


}