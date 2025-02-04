/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.services.places;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Override
    public Set<Place> findAll() {
        return Set.of();
    }

    @Override
    public Place findById(Long aLong) {
        return null;
    }

    @Override
    public Place save(Place place) {
        return null;
    }


}
