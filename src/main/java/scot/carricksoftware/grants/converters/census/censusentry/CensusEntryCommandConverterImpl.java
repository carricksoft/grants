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
public class CensusEntryCommandConverterImpl implements CensusEntryCommandConverter {

    @Override
    public CensusEntry convert(@NotNull CensusEntryCommand source) {
        CensusEntry target = new CensusEntry();
        target.setId(source.getId());
        target.setCensus(source.getCensus());
        target.setPerson(source.getPerson());
        target.setOtherPerson(source.getOtherPerson());
        return target;
    }

}
