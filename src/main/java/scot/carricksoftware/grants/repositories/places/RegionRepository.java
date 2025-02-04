/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.places;

import org.springframework.data.repository.CrudRepository;
import scot.carricksoftware.grants.domains.places.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {
}
