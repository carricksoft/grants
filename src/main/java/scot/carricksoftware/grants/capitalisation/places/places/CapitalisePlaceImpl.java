

/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.places;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;

@Component
public class CapitalisePlaceImpl implements CapitalisePlace
{

   private final CapitaliseString capitaliseString;

    public CapitalisePlaceImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PlaceCommand command) {
        command.setName(capitaliseString.capitalise(command.getName()));
    }
}
