

/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.places.regions;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;

@Component
public class CapitaliseRegionImpl implements CapitaliseRegion
{

   private final CapitaliseString capitaliseString;

    public CapitaliseRegionImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(RegionCommand command) {
        command.setName(capitaliseString.capitalise(command.getName()));
    }
}
