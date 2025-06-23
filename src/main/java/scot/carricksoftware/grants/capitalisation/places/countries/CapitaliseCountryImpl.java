

/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.countries;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;

@Component
public class CapitaliseCountryImpl implements CapitaliseCountry {

   private final CapitaliseString capitaliseString;

    public CapitaliseCountryImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(CountryCommand command) {
        command.setName(capitaliseString.capitalise(command.getName()));
    }
}
