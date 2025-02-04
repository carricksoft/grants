/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;

public interface PlaceService {

    @SuppressWarnings("unused")
    Set<Place> findAll();

    @SuppressWarnings({"SameReturnValue", "unused"})
    Place findById(Long aLong);

    @SuppressWarnings({"UnusedReturnValue", "unused", "SameReturnValue"})
    Place save(Place place);

}
