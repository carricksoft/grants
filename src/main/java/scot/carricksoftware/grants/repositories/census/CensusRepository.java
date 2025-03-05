/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.Census;

@SuppressWarnings("unused")
@Repository
public interface CensusRepository extends PagingAndSortingRepository<Census, Long> {


}