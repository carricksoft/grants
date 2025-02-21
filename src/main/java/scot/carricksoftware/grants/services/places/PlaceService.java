/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.List;

public interface PlaceService {

    @SuppressWarnings("unused")
    Place findById(Long id);

    @SuppressWarnings("unused")
    Place save(Place place);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Place> getPagedCountries(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    PlaceCommand savePlaceCommand(PlaceCommand placeCommand);

    List<Place> findAll();
}
