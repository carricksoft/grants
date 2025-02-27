/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census.censusentry;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@Component
public class CensusEntryConverterImpl implements CensusEntryConverter {

    @Override
    public CensusEntryCommand convert(@NotNull CensusEntry source) {
        CensusEntryCommand target = new CensusEntryCommand();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        target.setCensus(source.getCensus());
        target.setOtherPerson(source.getOtherPerson());
        return target;
    }
}
