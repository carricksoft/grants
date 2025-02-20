/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

@Component
public class RegionConverterImpl implements Converter<Region, RegionCommand> {

    @Override
    public RegionCommand convert(Region source) {
        RegionCommand target = new RegionCommand();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPlaces(source.getPlaces());
        return target;
    }
}
