/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

@SuppressWarnings("NullableProblems")
public interface CensusCommandConverter extends Converter<CensusCommand, Census> {

    Census convert(CensusCommand censusCommand);
}
