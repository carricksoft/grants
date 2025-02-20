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
public class RegionCommandConverterImpl implements Converter<RegionCommand, Region> {

    @Override
    public Region convert(RegionCommand source) {
        Region target = new Region();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPlaces(source.getPlaces());
        return target;
    }


}
