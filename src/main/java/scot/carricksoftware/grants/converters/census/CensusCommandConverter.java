/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

public interface CensusCommandConverter extends Converter<CensusCommand, Census> {

    Census convert(@NotNull CensusCommand source);
}
