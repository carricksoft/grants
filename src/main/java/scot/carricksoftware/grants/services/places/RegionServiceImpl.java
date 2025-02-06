/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.RegionRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegionServiceImpl implements RegionService {

    private static final Logger logger = LogManager.getLogger(RegionServiceImpl.class);
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Set<Region> findAll() {
        logger.debug("RegionServiceImpl::save");
        Set<Region> regionSet = new HashSet<>();
        regionRepository.findAll().iterator().forEachRemaining(regionSet::add);
        return regionSet;
    }

    @Override
    public Region findById(Long aLong) {
        return null;
    }

    @Override
    public Region save(Region region) {
        logger.debug("RegionServiceImpl::save");
        return regionRepository.save(region);
    }

}
