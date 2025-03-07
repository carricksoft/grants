package scot.carricksoftware.grants.domains.certificates.deathcertificates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeathCertificateTest {


    private DeathCertificate deathCertificate;


    @Before
    public void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(deathCertificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        deathCertificate.setId(id);
        assertEquals(id, deathCertificate.getId());
    }


}