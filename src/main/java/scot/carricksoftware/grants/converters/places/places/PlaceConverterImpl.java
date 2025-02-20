/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.places;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public class PlaceConverterImpl implements Converter<Place, PlaceCommand> {

    @Override
    public PlaceCommand convert(Place source) {
        PlaceCommand target = new PlaceCommand();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCountry(source.getCountry());
        target.setRegion(source.getRegion());

        return target;
    }
}
