/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.Set;

@Service
public class PlaceServiceImpl implements PlaceService {

    private static final Logger logger = LogManager.getLogger(PlaceServiceImpl.class);
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Set<Place> findAll() {
        return Set.of();
    }

    @Override
    public Place findById(Long aLong) {
        return null;
    }

    @Override
    public Place save(Place place) throws GrantsException {
        logger.debug("PlaceServiceImpl::save");
        if (place == null ||
                place.getCountry() == null ||
                place.getRegion() == null) {
            throw new GrantsException("Place is invalid when saving");
        }
        return placeRepository.save(place);
    }

}
