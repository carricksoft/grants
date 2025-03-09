package scot.carricksoftware.grants.converters.places.countries;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

public interface CountryConverter extends Converter<Country, CountryCommand> {

}
