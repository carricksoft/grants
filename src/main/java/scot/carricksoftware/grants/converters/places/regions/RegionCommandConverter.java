/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;


import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@SuppressWarnings("unused")
public interface RegionCommandConverter extends Converter<RegionCommand, Region> {

    @Override
    Region convert(@NotNull RegionCommand source);


}
