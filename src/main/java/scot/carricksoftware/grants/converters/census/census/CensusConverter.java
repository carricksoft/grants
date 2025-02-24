/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census.census;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

public interface CensusConverter extends Converter<Census, CensusCommand> {
    CensusCommand convert(@org.jetbrains.annotations.NotNull Census source);
}
