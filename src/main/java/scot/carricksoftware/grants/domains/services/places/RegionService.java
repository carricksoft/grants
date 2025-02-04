/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.services.places;

import scot.carricksoftware.grants.domains.places.Region;

import java.util.Set;

@SuppressWarnings("SameReturnValue")
public interface RegionService {

    @SuppressWarnings("unused")
    Set<Region> findAll();

    @SuppressWarnings({"SameReturnValue", "unused"})
    Region findById(Long aLong);

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    Region save(Region region);

}
