/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.services.places;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.Set;

@Service
public class RegionServiceImpl implements RegionService {

    @Override
    public Set<Region> findAll() {
        return Set.of();
    }

    @Override
    public Region findById(Long aLong) {
        return null;
    }

    @Override
    public Region save(Region region) {
        return null;
    }

}
