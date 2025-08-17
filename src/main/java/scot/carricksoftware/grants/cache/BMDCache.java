/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.List;

public interface BMDCache {

    @SuppressWarnings("UnusedReturnValue")
    List<Person> getPeople();
    void invalidatePeople();

    List<Place> getPlaces();

    void invalidatePlaces();
}
