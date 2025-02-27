/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census.censusentry;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

public interface CensusEntryCommandConverter extends Converter<CensusEntryCommand, CensusEntry> {

    CensusEntry convert(@NotNull CensusEntryCommand source);
}
