package scot.carricksoftware.grants.converters.places.countries;

import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.domains.places.Country;

public class CountryConverterImpl implements CountryConverter{

    @Override
    public CountryCommand convert(Country source) {
        CountryCommand target = new CountryCommandImpl();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}
