/*
 * Copyright (c) 2025- 28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.List;

@SuppressWarnings("SameReturnValue")
public interface RegionService {
    @SuppressWarnings("unused")
    Region findById(Long id);

    @SuppressWarnings("unused")
    Region save(Region region);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Region> getPagedCountries(int pageNumber);

    long count();

    @SuppressWarnings("unused")
    RegionCommand saveRegionCommand(RegionCommand regionCommand);

    List<Region> findAll();
}
