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
public class CensusConverterImpl implements CensusConverter {

    @Override
    public CensusCommand convert(@NotNull Census source) {
        CensusCommand target = new CensusCommand();
        target.setPlace(source.getPlace());
        target.setDate(source.getDate());
        target.setId(source.getId());
        return target;
    }
}
