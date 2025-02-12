/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.constants.ExceptionConstants;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("LoggingSimilarMessage")
@Service
public class PlaceServiceImpl implements PlaceService {

    private static final Logger logger = LogManager.getLogger(PlaceServiceImpl.class);
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Set<Place> findAll() {
        logger.debug("PlaceServiceImpl::save");
        Set<Place> placeSet = new HashSet<>();
        placeRepository.findAll().iterator().forEachRemaining(placeSet::add);
        return placeSet;
    }

    @Override
    public Place findById(Long id) {
        logger.debug("PersonServiceImpl::findById");
        Optional<Place> person = placeRepository.findById(id);
        return person.orElse(null);
    }

    @Override
    public Place save(Place place) throws GrantsException {
        logger.debug("PlaceServiceImpl::save");
        if (place == null ||
                place.getCountry() == null ||
                place.getRegion() == null) {
            throw new GrantsException(ExceptionConstants.INVALID_PLACE);
        }
        return placeRepository.save(place);
    }

}
