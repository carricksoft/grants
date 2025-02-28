/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.repositories.certificates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import java.util.Optional;

@Repository
public interface BirthCertificateRepository extends PagingAndSortingRepository<BirthCertificate, Long> {

    BirthCertificate save(BirthCertificate birthCertificate);

    long count();

    void deleteById(Long id);

    Optional<BirthCertificate> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<BirthCertificate> findAll();

}
