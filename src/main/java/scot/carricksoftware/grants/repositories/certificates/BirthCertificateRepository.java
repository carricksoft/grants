/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

@SuppressWarnings("unused")
@Repository
public interface BirthCertificateRepository extends PagingAndSortingRepository<BirthCertificate, Long> {


}
