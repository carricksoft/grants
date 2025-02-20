/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.places;


import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

@SuppressWarnings("unused")
public interface PlaceCommandConverter extends Converter<PlaceCommand, Place> {

    @Override
    Place convert(@NotNull PlaceCommand source);


}
