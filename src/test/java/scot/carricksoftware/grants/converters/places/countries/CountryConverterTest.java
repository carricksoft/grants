package scot.carricksoftware.grants.converters.places.countries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import scot.carricksoftware.grants.domains.places.Country;

import java.util.Objects;

import static org.junit.Assert.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@RunWith(JUnit4.class)
public class CountryConverterTest {

    CountryConverter converter;

    @Before
    public void setUp() {
        converter = new CountryConverterImpl();
    }

    @Test
    public void converterTest() {
        Country country = new Country();
        Long id = GetRandomLong();
        String name = GetRandomString();

        country.setId(id);
        country.setName(name);

        assertEquals(id, Objects.requireNonNull(converter.convert(country)).getId());
        assertEquals(name, Objects.requireNonNull(converter.convert(country)).getName());
    }
}