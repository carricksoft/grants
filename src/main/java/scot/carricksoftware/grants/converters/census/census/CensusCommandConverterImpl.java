/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census.census;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

@Component
public class CensusCommandConverterImpl implements CensusCommandConverter {

    @Override
    public Census convert(@NotNull CensusCommand source) {
        Census target = new Census();
        target.setPlace(source.getPlace());
        target.setCensusEntries(source.getCensusEntries());
        target.setDate(source.getDate());
        target.setId(source.getId());
        return target;
    }
}
