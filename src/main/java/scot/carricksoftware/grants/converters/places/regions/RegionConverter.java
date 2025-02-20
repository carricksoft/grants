/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;


import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@SuppressWarnings("unused")
@Component
public interface RegionConverter extends Converter<Region, RegionCommand> {

    RegionCommand convert(@NotNull Region source);
}
